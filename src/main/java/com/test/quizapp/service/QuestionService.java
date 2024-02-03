package com.test.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.quizapp.entity.Question;
import com.test.quizapp.repository.QuestionDAO;

@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDAO.save(question);
			return new ResponseEntity<>("success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);

	}

	public Question getQuestionById(Integer id) {
		// Assuming your QuestionDAO has a method to find a question by its ID
		return questionDAO.findById(id).orElse(null);
	}

	public void updateQuestion(Question existingQuestion, Question updatedQuestion) {
		// Update the existing question with the new data
		existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
		existingQuestion.setOption1(updatedQuestion.getOption1());
		existingQuestion.setOption2(updatedQuestion.getOption2());
		existingQuestion.setOption3(updatedQuestion.getOption3());
		existingQuestion.setOption4(updatedQuestion.getOption4());
		existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
		existingQuestion.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
		existingQuestion.setCategory(updatedQuestion.getCategory());

		// Save the updated question
		questionDAO.save(existingQuestion);
	}

	public void deleteQuestion(Question existingQuestion) {
		questionDAO.delete(existingQuestion);
		
	}

}
