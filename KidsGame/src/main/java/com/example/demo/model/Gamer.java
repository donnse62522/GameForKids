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
@Table(name = "gamer")
public class Gamer implements Serializable{

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "total_score", nullable = false)
    private Long totalScore;
    
	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;
}
