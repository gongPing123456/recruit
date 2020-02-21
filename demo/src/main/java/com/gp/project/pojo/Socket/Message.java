package com.gp.project.pojo.Socket;

import lombok.Data;

/**
 * @time 2020/2/21 11:15
 * @Author gp
 */
@Data
public class Message {
	/**
	 * 发送信息的用户
	 */
	private String name;
	/**
	 * 消息
	 */
	private String content;
	/**
	 * 接收人用户
	 */
	private String receiver;

}
