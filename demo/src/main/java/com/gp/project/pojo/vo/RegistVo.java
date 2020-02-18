package com.gp.project.pojo.vo;

import java.io.Serializable;

/**
 * 用户注册  返回信息
 * @time 2020/2/18 11:26
 * @Author gp
 */
public class RegistVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String loginName;
	private String userPassword;
	private String token;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
