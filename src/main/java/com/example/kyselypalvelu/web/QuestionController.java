package com.example.kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public @ResponseBody List<Question> getQuestions(){
		return (List<Question>) repository.findAll();
	}
	
	@RequestMapping(value="/questions/{id}", method=RequestMethod.GET)
	public @ResponseBody Question getQuestionById(@PathVariable("id") Long questionId){
		return repository.findOne(questionId);
	}
	/*
	@RequestMapping(value = "/savequestion/{surveyid}", method = RequestMethod.POST)
	public @ResponseBody Question saveQuestion(@RequestBody Question question, @PathVariable("surveyid") Long surveyid) {
	    question.setSurvey(new Survey(surveyid));
	    repository.save(question);
	    return question;
	}
	*/
	@RequestMapping(value = "/addquestion/{id}", method = RequestMethod.GET)
	public String addQuestion(@PathVariable("id") Long surveyid, Model model, Question question) {
	
		System.out.println("Survey id " + surveyid );
		System.out.println("Survey id " + srepository.findOne(surveyid));
		model.addAttribute("question", new Question());
		
		model.addAttribute("survey", srepository.findOne(surveyid));
		question.setSurvey(new Survey(surveyid));
		repository.save(question);
		return "redirect:../listsurveys";
	} 	
	
	/*
	 *  Myöhempää käyttöä varten??
			@RequestMapping(value = "/addquestion", method = RequestMethod.POST)
		public String saveQuestion(Question question) {
			repository.save(question);
			return "redirect:addsurvey";
		}
	*/
		

}

