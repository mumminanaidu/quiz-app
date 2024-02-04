package com.test.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.quizapp.entity.Question;
import com.test.quizapp.entity.QuestionWrapper;
import com.test.quizapp.entity.Quiz;
import com.test.quizapp.entity.Response;
import com.test.quizapp.repository.QuestionDAO;
import com.test.quizapp.repository.QuizDAO;

@Service
public class QuizService {

	@Autowired
	QuizDAO quizDAO;

	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		List<Question> questions = questionDAO.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDAO.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDAO.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<>();

		for (Question q : questionFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDAO.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i=0;
		
		
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
					right++;
			i++;
			
		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
