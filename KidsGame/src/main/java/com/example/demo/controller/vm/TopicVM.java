package com.example.demo.controller.vm;

import java.io.Serializable;

import lombok.Data;

@Data
public class TopicVM implements Serializable{

	private Long idTopic;
	
	private String description;
	
	private String urlImage;
	
}
