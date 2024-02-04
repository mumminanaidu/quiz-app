package com.test.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.quizapp.entity.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer>{

}
