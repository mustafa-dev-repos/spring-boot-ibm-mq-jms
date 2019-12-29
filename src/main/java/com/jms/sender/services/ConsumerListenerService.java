package com.jms.sender.services;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ConsumerListenerService {
	
	@Autowired
	private MessageService messageService;
	
	
    @JmsListener(destination = "DEV.QUEUE.1", containerFactory = "myFactory")
    public void receiveMessage(String message) {
        System.out.println("DEV.QUEUE.1 received ~" + message + "~");
        
        Message msg = new Message();
        msg.setMessage("Hello");
        msg.setId(new Random().nextInt(100000));
        //msg.setId(1);
        
        
        //messageService.save(msg);
        List<Message> messageList = messageService.findAllByStatus(1);
        messageList.forEach(m -> System.out.println(m.getId() + " " +m.getMessage()));
        
        System.out.println("**********");
        
        messageList = messageService.findAllByStatus(0);
        messageList.forEach(m -> System.out.println(m.getId() + " " +m.getMessage()));
        
//        System.out.println("1");
//        Page<Message> dataList = messageService.findAllLimitOne();
//        dataList.forEach( m -> System.out.println(m.getId() +" "+ m.getMessage()));
//        System.out.println("2");

//        if (messageService.existsById(1)) {
//        	throw new RuntimeException("Already exists.");
//        }
        
        
        //throw new RuntimeException("error occured.");
    }

}
