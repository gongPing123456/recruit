package com.gp.project.common;

import org.springframework.stereotype.Component;

/**
 * @time 2019/9/12 11:34
 * @Author gp
 */
@Component
public class Constants {

	/**
	 * 全局默认状态，包括正常、异常、删除的数字和字符串
	 */
	public static final int GLOBAL_NORMAL_STATUS_INT = 200;
	public static final int GLOBAL_ERROR_STATUS_INT = 500;
	/**
	 * 密码 信息
	 */
	public  static final int PWD_MAX_LENGTH=16;
	public static final  int PWD_MIN_LENGTH=8;


	/**
	 * 存储图片的路径
	 */
	public static final String USER_AVATAR_PATH = "D://image//userImage//";
	public static final String ROOM_PACTURE_PATH = "D://课程设计//src//main//webapp//static//images//roomImage//";


	public static final String ROOM_PATH="localhost:8080/rent/static/roomImage/";


	/**
	 * 简历存储地址
	 */
	public static final  String RESUME_PATH="D:\\biye\\resumeAnalysis\\";
	public static final  String USER_AVATAR_PHOTO="D:\\biye\\user_photo_avatar\\";
	/**
	 * 用户role id
	 */
	public static final int ROLE_ID = 1;
	public static final int ERROR_INT = 0;

	/**
	 * 是否为图片
	 */
	public static final int ERROR_IMAGE_INT = 0;

	/**
	 * 判断请求是否成功
	 */
	public static final String SUCCESS_MSG = "请求成功";
	public static final String ERROR_MSG = "请求失败";


	/**
	 * session中存放用户信息的key值
	 */
	public static final String SESSION_USER_INFO = "userInfo";
	public static final String SESSION_USER_USERNAME = "username";
	public static final String SESSION_USER_PERMISSION = "userPermission";
	public static final String SESSION_IMAGE_CODE= "imageCode";
	public static final String SESSION_EMAIL_CODE= "EmailCode";


}