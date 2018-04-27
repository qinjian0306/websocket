package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {


	/**
	 * 注册认证 客户端的连接端点 withSockJS允许客户端利用sockjs进行浏览器兼容性处理
	 * @param registry
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/socket");
		registry.addEndpoint("/socket").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic"); // 设置服务器广播消息的基础路径
		config.setApplicationDestinationPrefixes("/ws"); // 设置客户端订阅消息的基础路径
//		config.setPathMatcher(new AntPathMatcher("."));// 可以已“.”来分割路径，看看类级别的@messageMapping和方法级别的@messageMapping
	}

}
