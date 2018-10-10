package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.controller.vm.EnglishVM;
import com.example.demo.model.Topic;
import com.example.demo.repository.TopicRepository;

@Service
@ComponentScan("com.example.demo.repository")
public class QuestionServiceImp implements QuestionService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Override
	public List<EnglishVM> getEnglish(Long topicID) {
		Topic topic = topicRepository.findOne(topicID);
		return topic.getQuestions().stream().map(ques -> {
			EnglishVM vm = new EnglishVM();
				vm.setEngId(ques.getId());
				vm.setDescription(ques.getAnswer());
				vm.setUrlImg(ques.getImage());
				vm.setScore(ques.getScore());
            return vm;
        }).collect(Collectors.toList());
//		return subject.getTopics().stream().map(topic -> TopicMapper.INSTANCE.toTopicVM(topic))
//                .collect(Collectors.toList());
	}

	@Override
	public List<EnglishVM> getEnglish(String topicName) {
		Topic topic = topicRepository.findByName(topicName);
		return topic.getQuestions().stream().map(ques -> {
			EnglishVM vm = new EnglishVM();
				vm.setEngId(ques.getId());
				vm.setDescription(ques.getAnswer());
				vm.setUrlImg(ques.getImage());
				vm.setScore(ques.getScore());
            return vm;
        }).collect(Collectors.toList());
	}

}
