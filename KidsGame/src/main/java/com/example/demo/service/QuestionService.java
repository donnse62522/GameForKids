package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.vm.EnglishVM;

public interface QuestionService {

	public List<EnglishVM> getEnglish(Long topicID);
	
	public List<EnglishVM> getEnglish(String topicName);
}
