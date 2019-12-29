package com.jms.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class SpringBootIbmMqJmsApplication {

	public static void main(String[] args) {
		
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootIbmMqJmsApplication.class, args);
        // Send a message
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello IBM MQ");
	}

}
