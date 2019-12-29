package com.jms.sender.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query(value = "Select * from message where status=?1", nativeQuery = true)
	public List<Message> findAllByStatus(Integer status);
	
}
