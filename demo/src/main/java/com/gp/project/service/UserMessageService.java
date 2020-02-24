package com.gp.project.service;

import com.gp.project.pojo.Socket.ChatFriend;
import com.gp.project.pojo.UserInfo;

import java.util.List;

/**
 * @time 2020/2/22 13:44
 * @Author gp
 */
public interface UserMessageService {
	/**
	 * 获取好友列表
	 * @param username
	 * @return
	 */
	List<UserInfo> getFriendlist(String username);
}
