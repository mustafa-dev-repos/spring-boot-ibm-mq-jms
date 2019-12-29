package com.jms.sender.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;
	
	@Override
	public List<Message> findAll() {
		List<Message> messageList =  (List<Message>) messageRepository.findAll();
		return messageList;
	}

	@Override
	public Message save(Message message) {
		try{
			messageRepository.save(message);
        }catch(Exception e){
        	e.printStackTrace();
        }
		return message;
	}

	@Override
	public boolean existsById(int id) {
		return messageRepository.existsById(id);
	}

	@Override
	public Page<Message> findAllLimitOne() {
		Pageable pageable = PageRequest.of(0, 1);
		Page<Message> messageList =  (Page<Message>) messageRepository.findAll(pageable);
		return messageList;
	}

	@Override
	public List<Message> findAllByStatus(Integer status) {
		List<Message> messageList =  (List<Message>) messageRepository.findAllByStatus(status);
		return messageList;
	}

}
