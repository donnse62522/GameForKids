package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.vm.EnglishVM;
import com.example.demo.controller.vm.SubjectVM;
import com.example.demo.controller.vm.TopicVM;
import com.example.demo.model.Subject;
import com.example.demo.service.QuestionService;
import com.example.demo.service.SubjectService;
import com.example.demo.service.TopicService;

@Controller
@RequestMapping("/api")
public class KidsGameController {

	@Autowired
	SubjectService subjectService;
	
	@Autowired
	TopicService topicService;
	
	@Autowired
	QuestionService questionService;

	@GetMapping(value = "/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubjectVM>> getSubject() {
		List<SubjectVM> vms = subjectService.getSubject();
		System.out.println("getSubject: "+ vms);
		return new ResponseEntity<List<SubjectVM>>(vms, HttpStatus.OK);
	}
	@GetMapping(value = "/topics/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TopicVM>> getTopics(@PathVariable Long id) {
		List<TopicVM> vms = topicService.getTopics(id);
		System.out.println("getSubject: " + vms);
		return new ResponseEntity<List<TopicVM>>(vms, HttpStatus.OK);
	}

	@GetMapping(value = "/english/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EnglishVM>> getEnglish(@PathVariable Long id) {
		List<EnglishVM> vms = questionService.getEnglish(id);
		System.out.println("getEnglish: " + vms);
		return new ResponseEntity<List<EnglishVM>>(vms, HttpStatus.OK);
	}
	

	@GetMapping(value = "/topic-name/english/{topicName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EnglishVM>> getEnglish(@PathVariable String topicName) {
		List<EnglishVM> vms = questionService.getEnglish(topicName);
		System.out.println("getEnglishByTopicName: " + vms);
		return new ResponseEntity<List<EnglishVM>>(vms, HttpStatus.OK);
	}

}
