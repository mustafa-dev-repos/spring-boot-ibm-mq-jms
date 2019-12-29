package com.jms.sender.services;

import javax.jms.ConnectionFactory;
import javax.jms.Session;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JmsListenerConfiguration {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		defaultJmsListenerContainerFactory.setTransactionManager(jmsTransactionManager(connectionFactory));
		defaultJmsListenerContainerFactory.setSessionTransacted(true);
		defaultJmsListenerContainerFactory.setSessionAcknowledgeMode(Session.SESSION_TRANSACTED);
		defaultJmsListenerContainerFactory.setErrorHandler(new DefaultErrorHandler());
		configurer.configure(defaultJmsListenerContainerFactory, connectionFactory);
		return defaultJmsListenerContainerFactory;
	}

	@Bean
	public PlatformTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
		return new JmsTransactionManager(connectionFactory);
	}
}
