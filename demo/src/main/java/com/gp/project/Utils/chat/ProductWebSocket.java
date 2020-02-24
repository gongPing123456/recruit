package com.gp.project.utils.chat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.gp.project.pojo.Socket.ChatFriend;
import com.gp.project.pojo.Socket.ChatMessage;
import com.gp.project.pojo.UserInfo;
import com.gp.project.service.UserMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @time 2020/2/21 11:56
 * @Author gp
 */


@Component
@ServerEndpoint("/websocket/{username}")
public class ProductWebSocket {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public   static UserMessageService userMessageService;
	/**
	 * 好友列表
	 */
	private ChatFriend chatFriend;
	/**
	 * 消息列表
	 */
	private ChatMessage chatMessage;
	/**
	 * 在线人数
	 */
	public static int onlineNumber = 0;
	/**
	 * 以用户的姓名为key，WebSocket为对象保存起来
	 */
	private static Map<String,ProductWebSocket> clients = new ConcurrentHashMap<String, ProductWebSocket>();
	/**
	 * 会话
	 */
	private Session session;
	/**
	 * 用户名称
	 */
	private String username;
	/**
	 * 建立连接
	 *
	 * @param session
	 */
	@OnOpen
	public void onOpen(@PathParam("username") String username, Session session)
	{
		onlineNumber++;
		logger.info("现在来连接的客户id："+session.getId()+"用户名："+username);
		//获取好友列表
		List<UserInfo> friendlist = userMessageService.getFriendlist(username);
		this.username = username;
		this.session = session;
		logger.info("有新连接加入！ 当前在线人数" + onlineNumber);
		try {
			//messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
			//先给好友发送通知，说我上线了
			if (friendlist != null){
				Map<String,Object> map1 = Maps.newHashMap();
				map1.put("messageType",1);
				map1.put("username",username);
				sendMessageToFriends(JSON.toJSONString(map1),friendlist);
			}
			//把自己的信息加入到map当中去
			clients.put(username, this);
			//给自己发一条消息：告诉自己现在都有谁在线
			Map<String,Object> map2 = Maps.newHashMap();
			map2.put("messageType",3);
			//移除掉自己
			Set<String> set = clients.keySet();
			map2.put("onlineUsers",set);
			map2.put("friends",checkOnlineFriend(friendlist));
			sendMessageTo(JSON.toJSONString(map2),username);
		}
		catch (IOException e){
			logger.info(username+"上线的时候通知所有人发生了错误");
		}



	}

	@OnError
	public void onError(Session session, Throwable error) {
		logger.info("服务端发生了错误"+error.getMessage());
		//error.printStackTrace();
	}
	/**
	 * 连接关闭
	 */
	@OnClose
	public void onClose()
	{
		onlineNumber--;

		//webSockets.remove(this);
		clients.remove(username);
		try {
			//messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
			Map<String,Object> map1 = Maps.newHashMap();
			map1.put("messageType",2);
			map1.put("onlineUsers",clients.keySet());
			map1.put("username",username);
			sendMessageAll(JSON.toJSONString(map1),username);
		}
		catch (IOException e){
			logger.info(username+"下线的时候通知所有人发生了错误");
		}
		logger.info("有连接关闭！ 当前在线人数" + onlineNumber);
	}

	/**
	 * 收到客户端的消息
	 *
	 * @param message 消息
	 * @param session 会话
	 */
	@OnMessage
	public void onMessage(String message, Session session)
	{
		try {
			logger.info("来自客户端消息：" + message+"客户端的id是："+session.getId());
			JSONObject jsonObject = JSON.parseObject(message);
			String textMessage = jsonObject.getString("message");
			String fromusername = jsonObject.getString("username");
			String tousername = jsonObject.getString("to");
			//如果不是发给所有，那么就发给某一个人
			//messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
			Map<String,Object> map1 = Maps.newHashMap();
			map1.put("messageType",4);
			map1.put("textMessage",textMessage);
			map1.put("fromusername",fromusername);
			if(tousername.equals("All")){
				map1.put("tousername","所有人");
				sendMessageAll(JSON.toJSONString(map1),fromusername);
			}
			else{
				map1.put("tousername",tousername);
				sendMessageTo(JSON.toJSONString(map1),tousername);
			}
		}
		catch (Exception e){
			logger.info("发生了错误了");
		}

	}


	public void sendMessageTo(String message, String ToUserName) throws IOException {
		for (ProductWebSocket item : clients.values()) {
			if (item.username.equals(ToUserName) ) {
				item.session.getAsyncRemote().sendText(message);
				break;
			}
		}
	}

	public void sendMessageAll(String message,String FromUserName) throws IOException {
		for (ProductWebSocket item : clients.values()) {
			item.session.getAsyncRemote().sendText(message);
		}
	}

	/**
	 * 发送给自己的好友
	 * @param message
	 */
	public void sendMessageToFriends(String message,List<UserInfo> userInfoList){
		for (ProductWebSocket item : clients.values()) {
//			item.session.getAsyncRemote().sendText(message);
			for (int i=0;i<userInfoList.size();i++){
				if (item.username.equals(userInfoList.get(i).getLoginName())){
					item.session.getAsyncRemote().sendText(message);
				}
			}
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineNumber;
	}

	/**
	 * 判断在线好友
	 * @param friends
	 * @return
	 */
	public List<UserInfo> checkOnlineFriend(List<UserInfo> friends){
		List<UserInfo> list=new ArrayList<>();
		for (ProductWebSocket item:clients.values())
		{
			for (int i=0;i<friends.size();i++){
				if (item.username.equals(friends.get(i).getLoginName())){
					UserInfo userInfo = new UserInfo();
					userInfo.setLoginName(item.username);
					list.add(userInfo);
				}
			}
		}
		return list;
	}

	/**
	 * 发送语句
	 * @param productWebSocket
	 * @param message
	 */
	public void sessionSend(ProductWebSocket productWebSocket,String message){
		synchronized(productWebSocket.session){
			productWebSocket.session.getAsyncRemote().sendText(message);
		}
	}
}
