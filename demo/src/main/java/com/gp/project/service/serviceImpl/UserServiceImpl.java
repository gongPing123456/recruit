package com.gp.project.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gp.project.Utils.CommonUtils;
import com.gp.project.Utils.JWTUtils;
import com.gp.project.Utils.MD5;
import com.gp.project.common.Constants;
import com.gp.project.common.MsgCode;
import com.gp.project.common.Result;
import com.gp.project.mapper.UserInfoDAO;
import com.gp.project.mapper.UserResumeInfoDAO;
import com.gp.project.pojo.UserInfo;
import com.gp.project.pojo.UserResumeInfo;
import com.gp.project.pojo.vo.LoginVo;
import com.gp.project.pojo.vo.RegistVo;
import com.gp.project.pojo.vo.ResumeVo;
import com.gp.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @time 2020/1/16 15:25
 * @Author gp
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/*******简历解析url******/
	private static final String ANALYSIS_RESUME_URL = "http://cv-extract.com/api/extract";

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Autowired
	private UserResumeInfoDAO resumeInfoDAO;

	/**
	 * 用户登录
	 *
	 * @param jsonObject
	 * @return
	 */
	@Override
	public Result login(String jsonObject, HttpServletRequest request) throws UnknownHostException {
		Result result;
		UserInfo userInfo = JSON.parseObject(jsonObject, UserInfo.class);
		//根据username  获取信息
		UserInfo getUserInfo = userInfoDAO.selectByUserName(userInfo.getLoginName());
		result = checkLogin(userInfo, getUserInfo);
		if (result.getCode() != Constants.GLOBAL_NORMAL_STATUS_INT) {
			return result;
		}
		//修改ip
		InetAddress ip = InetAddress.getLocalHost();
		getUserInfo.setLastLoginIp(ip.getHostAddress());
		//修改登录时间
		getUserInfo.setLastLoginTime(new Date(System.currentTimeMillis()));
		userInfoDAO.updateByPrimaryKeySelective(getUserInfo);
		//生成token    在登录判断是否有token
		String token = JWTUtils.TokenTest(getUserInfo.getLoginName());
		request.getSession().setAttribute("token", token);
		LoginVo loginVo = new LoginVo(getUserInfo.getId(),
				getUserInfo.getLoginName(),
				token);
		result.setData(loginVo);
		return result;
	}

	/**
	 * 注册
	 *
	 * @param jsonObject
	 * @return
	 */
	@Override
	public Result regist(String jsonObject) {
		Result result;
		UserInfo userInfo = JSON.parseObject(jsonObject, UserInfo.class);
		UserInfo getUserInfo = userInfoDAO.selectByUserName(userInfo.getLoginName());
		result = checkRegist(userInfo, getUserInfo);
		if (result.getCode() != Constants.GLOBAL_NORMAL_STATUS_INT) {
			return result;
		}
		//新增用户
		userInfo.setCreateTime(new Date());
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		userInfo.setLastLoginIp(ip.getHostAddress());
		userInfo.setUserPassword(MD5.MD5Lower(userInfo.getUserPassword(), userInfo.getLoginName()));
		userInfoDAO.insertSelective(userInfo);
		//生成返回信息
		RegistVo registVo = new RegistVo();
		registVo.setLoginName(userInfo.getLoginName());
		registVo.setUserPassword(userInfo.getUserPassword());
		registVo.setToken(JWTUtils.TokenTest(userInfo.getLoginName()));

		result.setData(registVo);
		return result;
	}

	/**
	 * 简历分析
	 *
	 * @param file
	 * @return
	 */
	@Override
	public Result resumeAnalysis(MultipartFile file) {
		Result result = new Result();
		//名称
		String finalPath = Constants.RESUME_PATH + file.getOriginalFilename();
		String uploadFile = "";
		try {
			CommonUtils.receiveFile(file, finalPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			uploadFile = CommonUtils.uploadResumeFile(ANALYSIS_RESUME_URL, finalPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//删掉 简历
		CommonUtils.deleteFile(finalPath);
		ResumeVo resumeVo=null;
		try {
			resumeVo= JSON.parseObject(uploadFile, ResumeVo.class);
		}
		catch (Exception e){
			logger.info("解析JSON异常");
			Result.error(result,MsgCode.JSON_ERROR);
			return result;
		}
		Result.success(result, resumeVo.getData());
		System.out.println(uploadFile);
		return result;
	}

	/**
	 * 获取简历信息
	 *
	 * @param request
	 * @param json
	 * @return
	 */
	@Override
	public Result resumeView(String json, HttpServletRequest request) {
		//根据用户名 获取简历信息
		Result result = new Result();
		//request.getSession().getAttribute("loginName");
		UserInfo userInfo = userInfoDAO.selectByUserName(json);
		UserResumeInfo resumeByName = resumeInfoDAO.getResumeById(userInfo.getId());
		Boolean resume = isResume(resumeByName);
		if (!resume) {
			Result.error(result, MsgCode.RESUME_NOT_EXIST);
			return result;
		}
		Result.success(result, resumeByName);
		return result;
	}

	/**
	 * 简历的更新
	 *
	 * @param json
	 * @return
	 */
	@Override
	public Result updateResume(String json) {
		Result result = new Result();
		UserResumeInfo userResumeInfo = JSON.parseObject(json, UserResumeInfo.class);
		int i = resumeInfoDAO.updateByPrimaryKeySelective(userResumeInfo);
		if (i != 1) {
			Result.error(result, MsgCode.UPDATE_ERROR);
			return result;
		}
		Result.success(result, null);
		return result;
	}

	/**
	 * 新增信息
	 *
	 * @param json
	 * @return
	 */
	@Override
	public Result insertResume(String json) {
		Result result = new Result();
		UserResumeInfo userResumeInfo = JSON.parseObject(json, UserResumeInfo.class);
		/***
		 * 判断必填信息是否填完整了
		 */
		int i = resumeInfoDAO.insertSelective(userResumeInfo);
		if (i != 1) {
			Result.error(result, MsgCode.INSERT_ERROR);
			return result;
		}
		Result.success(result, null);
		return result;
	}

	/**
	 * 头像上传
	 *
	 * @param file
	 * @return
	 */
	@Override
	public Result uploadAvatar(MultipartFile file, String name) {
		Result result = new Result();
		//获取文件名称
		//String finalPath = Constants.USER_AVATAR_PATH + file.getOriginalFilename();
		UserInfo userInfo = userInfoDAO.selectByUserName(name);
		String finalPath=Constants.USER_AVATAR_PHOTO+name+"."+CommonUtils.fileExtension(file);
		//判断文件是否存在 存在就删除
		File isfile=new File(finalPath);
		if (isfile.exists())
		{
			CommonUtils.deleteFile(finalPath);
		}
		//上传文件
		try {
			CommonUtils.receiveFile(file, finalPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//判断是否为图片
		boolean isPicture = true;
		try {
			isPicture = CommonUtils.isPicture(finalPath);

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!isPicture) {
			//删除文件
			CommonUtils.deleteFile(finalPath);
			Result.error(result,MsgCode.FILE_TYPE_NOT_MATCH);
			return result;
		}
		userInfo.setPhotoPath(finalPath);
		userInfoDAO.updateByPrimaryKeySelective(userInfo);
        Result.success(result,null);
		return result;
	}

	/**
	 * 修改完善用户
	 * @param json
	 * @return
	 */
	@Override
	public Result updateUserInfo(String json) {
		Result result=new Result();
		UserInfo userInfo=JSON.parseObject(json,UserInfo.class);
		int i = userInfoDAO.updateByPrimaryKeySelective(userInfo);
		if (i == 1){
			Result.success(result,null);
			return result;
		}
		Result.error(result,MsgCode.UPDATE_ERROR);
		return result;
	}

	/**
	 * 查看用户是否已添加简历
	 *
	 * @param userResumeInfo
	 * @return
	 */
	private Boolean isResume(UserResumeInfo userResumeInfo) {
		if (userResumeInfo != null) {
			return true;
		}
		return false;
	}


	/**
	 * 判断登录信息
	 *
	 * @param userInfo    传送的user信息
	 * @param getUserInfo 查询的user信息
	 * @return
	 */
	private Result checkLogin(UserInfo userInfo, UserInfo getUserInfo) throws UnknownHostException {
		Result result = new Result();
		if (userInfo.getLoginName() == null || userInfo.getUserPassword() == null) {
			System.out.println("请输入完整信息");
			Result.error(result, MsgCode.REQUIRED_FIELDS_NULL);
			return result;
		}
		if (getUserInfo == null) {
			System.out.println("用户不存在");
			Result.error(result, MsgCode.USER_NOT_EXIST);
			return result;
		}
		System.out.println(MD5.valid(userInfo.getUserPassword(), userInfo.getLoginName(), getUserInfo.getUserPassword()));
		if (!MD5.valid(userInfo.getUserPassword(), userInfo.getLoginName(), getUserInfo.getUserPassword())) {
			System.out.println("密码不正确！");
			Result.error(result, MsgCode.PASSWORD_MISTAKEN);
			return result;
		}
		System.out.println("登录成功");
		Result.success(result, null);
		return result;
	}

	/**
	 * 注册判断
	 *
	 * @param userInfo
	 * @param getUserInfo
	 * @return
	 */
	private Result checkRegist(UserInfo userInfo, UserInfo getUserInfo) {
		Result result = new Result();
		if (userInfo.getLoginName() == null || userInfo.getUserPassword() == null
				|| userInfo.getRePassword() == null) {
			System.out.println("必填项为空");
			Result.error(result, MsgCode.REQUIRED_FIELDS_NULL);
			return result;
		}
		if (userInfo.getUserPassword().length() > Constants.PWD_MAX_LENGTH ||
				userInfo.getUserPassword().length() < Constants.PWD_MIN_LENGTH
		) {
			System.out.println("密码长度8~16之间");
			Result.error(result, MsgCode.PASSWORD_LENGTH_ERROR);
			return result;
		}
		if (!userInfo.getUserPassword().equals(userInfo.getRePassword())) {
			System.out.println("前两次密码不一致");
			Result.error(result, MsgCode.PASSWORD_NOT_SAME);
			return result;
		}
		if (getUserInfo != null) {
			System.out.println("账户已存在");
			Result.error(result, MsgCode.USER_EXIST);
			return result;
		}

		/**
		 * 其他添加添加 》》》》    用户名信息等等
		 */
		Result.success(result, null);
		return result;

	}


}
