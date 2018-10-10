package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "topic")
public class Topic  implements Serializable{
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
	
	@ManyToOne
	@JoinColumn(name = "sub_id")
	private Subject subject;

	@OneToMany(mappedBy = "topic")
	private List<Question> questions;
}
