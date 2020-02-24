package com.gp.project.mapper;

import com.gp.project.pojo.Socket.ChatFriend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatFriendDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatFriend record);

    int insertSelective(ChatFriend record);

    ChatFriend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatFriend record);

    int updateByPrimaryKey(ChatFriend record);

    /**
     * 根据用户id 获取好友列表
     * @param id
     * @return
     */
	List<ChatFriend> selectByuserId(Integer id);
}