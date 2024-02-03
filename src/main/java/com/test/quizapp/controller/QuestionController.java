package com.test.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.quizapp.entity.Question;
import com.test.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}

	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {
		try {
			// Check if the question with the given id exists
			Question existingQuestion = questionService.getQuestionById(id);

			if (existingQuestion != null) {
				// Update the existing question with the new data using the service method
				questionService.updateQuestion(existingQuestion, updatedQuestion);
				return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
			} else {
				// If the question with the given id does not exist
				return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to update question", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
	    try {
	        // Check if the question with the given id exists
	        Question existingQuestion = questionService.getQuestionById(id);

	        if (existingQuestion != null) {
	            // Delete the question
	            questionService.deleteQuestion(existingQuestion);
	            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
	        } else {
	            // If the question with the given id does not exist
	            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>("Failed to delete question", HttpStatus.BAD_REQUEST);
	    }
	}


}
