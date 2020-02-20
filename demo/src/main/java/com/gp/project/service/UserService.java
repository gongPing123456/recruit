package com.gp.project.service;

import com.alibaba.fastjson.JSONObject;
import com.gp.project.common.Result;
import com.gp.project.pojo.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

/**
 * @time 2020/1/16 15:24
 * @Author gp
 */
public interface UserService {
	Result login(String jsonObject, HttpServletRequest request) throws UnknownHostException;

	Result regist(String jsonObject);

	/**
	 * 简历分析
	 * @param file
	 * @return
	 */
	Result resumeAnalysis(MultipartFile file);

	/**
	 * 获取简历信息
	 * @param request
	 * @param json
	 * @return
	 */
	Result resumeView(String json ,HttpServletRequest request);

	/**
	 * 修改简历信息
	 * @param json
	 * @return
	 */
	Result updateResume(String json);

	/**
	 * 添加简历信息
	 * @param json
	 * @return
	 */
	Result insertResume(String json);

	/**
	 * 用户头像上传
	 * @param file
	 * @return
	 */
	Result uploadAvatar(MultipartFile file,String name);

	/**
	 * 修改用户 完善用户信息
	 * @param json
	 * @return
	 */
	Result updateUserInfo(String json);

	/**
	 * 查看用户是否已添加简历
	 * @param id
	 * @return
	 */
	//Result isResume(int id);

}
