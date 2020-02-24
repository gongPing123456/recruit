package com.gp.project.service.serviceImpl;

import com.gp.project.mapper.ChatFriendDAO;
import com.gp.project.mapper.UserInfoDAO;
import com.gp.project.pojo.Socket.ChatFriend;
import com.gp.project.pojo.UserInfo;
import com.gp.project.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @time 2020/2/22 13:46
 * @Author gp
 */
@Service
public class UserMessageServiceImpl implements UserMessageService {
	@Autowired
	UserInfoDAO userInfoDAO;
	@Autowired
	ChatFriendDAO chatFriendDAO;
	/**
	 * 获取好友列表
	 * @param username
	 * @return
	 */
	@Override
	public List<UserInfo> getFriendlist(String username) {
		List<UserInfo> infoList =new ArrayList<>();
		UserInfo userInfo = userInfoDAO.selectByUserName(username);
		// 获取朋友列表id
		List<ChatFriend> chatFriends = chatFriendDAO.selectByuserId(userInfo.getId());
		//判断是否有朋友
		if (chatFriends.size() == 0){
			return  null;
		}
		//取出好友的名字列表
		for (ChatFriend chatFriend:chatFriends){
			Integer friendId = chatFriend.getFriendId();
			UserInfo userInfo1 = userInfoDAO.selectByPrimaryKey(friendId);
			infoList.add(userInfo1);
		}
		return infoList;
	}
}
