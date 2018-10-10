package com.example.demo.controller.vm;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnglishVM  implements Serializable{
	
	private Long engId;
	
    private String description;
    
    private String urlImg;
    
    private int score;
}
