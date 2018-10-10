package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.controller.vm.TopicVM;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
@ComponentScan("com.example.demo.repository")
public class TopicServiceImp implements TopicService {
	
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public List<TopicVM> getTopics(Long subjectID) {
		Subject subject = subjectRepository.findOne(subjectID);
		return subject.getTopics().stream().map(topic -> {
			TopicVM vm = new TopicVM();
				vm.setIdTopic(topic.getId());
				vm.setDescription(topic.getName());
				vm.setUrlImage(topic.getDescription());
            return vm;
        }).collect(Collectors.toList());
//		return subject.getTopics().stream().map(topic -> TopicMapper.INSTANCE.toTopicVM(topic))
//                .collect(Collectors.toList());
	}

}
