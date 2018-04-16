package com.example.kyselypalvelu.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.kyselypalvelu.domain.Survey;
import com.example.kyselypalvelu.domain.SurveyRepository;

@Controller
public class SurveyController {


	@Autowired
	private SurveyRepository srepository;

	
	@RequestMapping(value="/surveys", method=RequestMethod.GET)
	public @ResponseBody List<Survey> getSurveys(){
		return (List<Survey>) srepository.findAll();
	}
	@RequestMapping(value="/surveys/{name}", method=RequestMethod.GET)//idis löytää nimen perusteella tietyt kyssärit tiettyyn surveyhyn
	public @ResponseBody List<Survey> getSurveys(@RequestParam(value="name", required=true) String name){
		return srepository.findByName(name);
	}

	@RequestMapping(value ="/surveys/survey{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Survey> findSurveyRest(@PathVariable("id") Long surveyid) {
		return srepository.findBysurveyid(surveyid);
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String addBook(@PathVariable("id") Long surveyId, Model model) {
		model.addAttribute("survey", srepository.findBysurveyid(surveyId));
	    return "";
	}  

	@RequestMapping(value = "/addsurvey", method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("surveys", srepository.findAll());
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}


	
	
}
