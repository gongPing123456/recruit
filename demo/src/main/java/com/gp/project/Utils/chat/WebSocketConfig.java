package com.gp.project.utils.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket配置类
 * @time 2020/2/21 11:55
 * @Author gp
 */

@Configuration
public class WebSocketConfig {

		@Bean
		public ServerEndpointExporter serverEndpointExporter() {
			return new ServerEndpointExporter();
		}

		@Bean
		public MyEndpointConfigure newConfigure() {
			return new MyEndpointConfigure();
		}
	}


