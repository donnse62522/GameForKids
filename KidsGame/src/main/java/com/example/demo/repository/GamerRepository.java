package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Gamer;

public interface GamerRepository extends JpaRepository<Gamer, Long> {

}
