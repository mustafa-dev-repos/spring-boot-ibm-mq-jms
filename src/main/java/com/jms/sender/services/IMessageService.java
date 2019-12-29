package com.jms.sender.services;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Lock;

public interface IMessageService {
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	List<Message> findAll();
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Page<Message> findAllLimitOne();
	
	Message save(Message message);
	boolean existsById(int id);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	List<Message> findAllByStatus(Integer status);
}
