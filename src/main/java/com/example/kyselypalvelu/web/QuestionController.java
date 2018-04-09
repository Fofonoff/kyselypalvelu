package com.example.kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselypalvelu.domain.Answer;
import com.example.kyselypalvelu.domain.AnswerRepository;
import com.example.kyselypalvelu.domain.Question;
import com.example.kyselypalvelu.domain.QuestionRepository;
import com.example.kyselypalvelu.domain.Survey;
import com.example.kyselypalvelu.domain.SurveyRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository repository;
	@Autowired
	private SurveyRepository srepository;
	@Autowired
	private AnswerRepository arepository;
	
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public @ResponseBody List<Question> getQuestions(){
		return (List<Question>) repository.findAll();
	}
	
	@RequestMapping(value="/question/{id}", method=RequestMethod.GET)
	public @ResponseBody Question getOneQuestion(@PathVariable("id") Long questionId){
		return repository.findOne(questionId);
	}
	@RequestMapping(value="/surveys", method=RequestMethod.GET)
	public @ResponseBody List<Survey> getSurveys(){
		return (List<Survey>) srepository.findAll();
	}
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public @ResponseBody List<Answer> getAnswers(){
		return (List<Answer>) arepository.findAll();
	}
	@RequestMapping(value ="/surveys/survey{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("id") Long surveyid) {
		return srepository.findById(surveyid);
	}
}
