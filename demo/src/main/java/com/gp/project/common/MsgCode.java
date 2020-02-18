package com.gp.project.common;

/**
 * @time 2020/1/21 15:57
 * @Author gp
 * 错误信息枚举类
 */
public enum MsgCode {

	/**
	 * 返回code
	 */

	CURRECT(200, "成功"),

	/**
	 * 用户登录的CODE
	 */
	USER_EXIST(300, "用户已存在"),
	PASSWORD_LENGTH_ERROR(301, "密码长度不在8~16之间"),
	REQUIRED_FIELDS_NULL(302, "必填项为空"),
	USER_NOT_EXIST(303, "用户不存在"),
	PASSWORD_MISTAKEN(304, "密码错误"),
	TOKEN_INVALID(305, "Token无效"),
	SERVER_EXCEPTION(306, "服务器异常"),
	MSGCODE_PARAMETER_MISTAKEN(307,"参数错误"),
	PASSWORD_NOT_SAME(308,"两次输入密码不同"),
	MOBILE_EXIST(309,""),
	MOBILE_EMPTY(310,""),
	MOBILE_FORMAT_MISTAKEN(311,""),
	EMAIL_FORMAT_MISTAKEN(312,"邮箱格式错误"),
	MSGCODE_INVALID(313,"验证码无效");


	int code;
	String message;

	MsgCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}

}
