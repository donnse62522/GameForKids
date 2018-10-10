package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "question")
public class Question implements Serializable {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;
    
    @Column(name = "image", nullable = false)
    private String image;
    
    @Column(name = "score", nullable = false)
    private int score;
    
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
}
