package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.vm.TopicVM;

public interface TopicService {

	public List<TopicVM>  getTopics(Long subjectID);
}
