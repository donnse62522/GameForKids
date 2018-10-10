package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.vm.SubjectVM;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImp implements SubjectService {

	@Autowired
	SubjectRepository repository;

	@Override
	public List<SubjectVM> getSubject() {
		return repository.findAll().stream().map(sub -> {
			SubjectVM vm = new SubjectVM();
			vm.setSubId(sub.getId());
			vm.setName(sub.getName());
			return vm;
		}).collect(Collectors.toList());
	}

}
