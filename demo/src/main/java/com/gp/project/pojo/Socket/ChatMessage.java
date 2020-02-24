package com.gp.project.pojo.Socket;

import java.io.Serializable;
import java.util.Date;

/**
 * chat_message
 * @author 
 */
public class ChatMessage implements Serializable {
    /**
     * 自增的id
     */
    private Integer id;

    /**
     * 用户好友表id  指明 发送信息和接收信息id
     */
    private Integer chatFriendId;

    /**
     * 信息的类型  0：是文本信息  1：图片 2 ：简历  文件
     */
    private Integer msgType;

    /**
     * 消息的文本
     */
    private String content;

    /**
     * 图片 或者简历的位置
     */
    private String msgUrl;

    /**
     * 创建的时间  可按照时间排序
     */
    private Date creatTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChatFriendId() {
        return chatFriendId;
    }

    public void setChatFriendId(Integer chatFriendId) {
        this.chatFriendId = chatFriendId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChatMessage other = (ChatMessage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChatFriendId() == null ? other.getChatFriendId() == null : this.getChatFriendId().equals(other.getChatFriendId()))
            && (this.getMsgType() == null ? other.getMsgType() == null : this.getMsgType().equals(other.getMsgType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getMsgUrl() == null ? other.getMsgUrl() == null : this.getMsgUrl().equals(other.getMsgUrl()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChatFriendId() == null) ? 0 : getChatFriendId().hashCode());
        result = prime * result + ((getMsgType() == null) ? 0 : getMsgType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getMsgUrl() == null) ? 0 : getMsgUrl().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chatFriendId=").append(chatFriendId);
        sb.append(", msgType=").append(msgType);
        sb.append(", content=").append(content);
        sb.append(", msgUrl=").append(msgUrl);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}