package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Topic;

@Transactional
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>, CrudRepository<Topic, Long> {

	public Topic findByName(String topicName);

}
