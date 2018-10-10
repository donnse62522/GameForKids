package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Subject;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
