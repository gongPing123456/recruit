package com.gp.project.mapper;

import com.gp.project.pojo.Socket.ChatMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    ChatMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
}