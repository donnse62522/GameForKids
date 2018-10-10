package com.example.demo.controller.vm;

import java.io.Serializable;

import lombok.Data;

@Data
public class SubjectVM  implements Serializable{
	
	private Long subId;
	
    private String name;
}
