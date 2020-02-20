package com.gp.project.pojo.vo;

import java.io.Serializable;

/**
 * 登录的返回信息
 * @time 2020/2/19 11:14
 * @Author gp
 */
public class LoginVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String loginName;
	private String token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginVo(int id, String loginName, String token) {
		this.id = id;
		this.loginName = loginName;
		this.token = token;
	}
}
