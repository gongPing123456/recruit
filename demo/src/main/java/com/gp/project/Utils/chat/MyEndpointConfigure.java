package com.gp.project.utils.chat;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.websocket.server.ServerEndpointConfig;

/**
 * 节点配置类
 * @time 2020/2/21 11:53
 * @Author gp
 */


public class MyEndpointConfigure extends ServerEndpointConfig.Configurator implements ApplicationContextAware {
	private static volatile BeanFactory context;

	@Override
	public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
		return context.getBean(clazz);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		MyEndpointConfigure.context = applicationContext;
	}
}