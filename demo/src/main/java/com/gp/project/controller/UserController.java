package com.gp.project.controller;

import com.gp.project.Utils.CommonUtils;
import com.gp.project.Utils.DateUtils;
import com.gp.project.common.Result;
import com.gp.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * 用户管理模块
 * @time 2020/1/16 15:23
 * @Author gp
 */
@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * 登录
	 * @param json
	 * @param request
	 * @return
	 * @throws UnknownHostException
	 */
	@RequestMapping("/login")
	public Result login(@RequestBody String json, HttpServletRequest request) throws UnknownHostException {
		//开始时间
		long begin =System.currentTimeMillis();
		Result result= userService.login(json,request);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"进行登录操作");
		return result;
	}

	/**
	 * 判断 是否已经登录
	 * @return
	 */
	/*@RequestMapping("/isLogin")
	public Result islogin(String token){
		Result result=new Result();
		if (token == null){
			result=Result.error();
		}

		return new Result();
	}*/

	@RequestMapping("/regist")
	public Result regist(@RequestBody String json){
		//开始时间
		long begin =System.currentTimeMillis();
		Result result= userService.regist(json);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"进行注册操作");
		return result;
	}
	/**
	 * 注册后免登录u哦那个了
	 */

	
	/**
	 * 简历分析
	 * @param file
	 * @return
	 */
	@RequestMapping("/resumeAnalysis")
	public Result  resumeAnalysis(@RequestParam(value = "file",required = false) MultipartFile file){
		//开始时间
		long begin =System.currentTimeMillis();
		Result result= userService.resumeAnalysis(file);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"进行简历分析操作");
		return result;
	}

	/**
	 *
	 * @param json
	 * @return
	 */
	@RequestMapping("/resumeView")
	public Result resumeView(@RequestBody String json,HttpServletRequest request){
		//开始时间
		long begin =System.currentTimeMillis();
		Result result= userService.resumeView(json,request);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"获取简历信息");
		return result;
	}


}
