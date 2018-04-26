package com.example.kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.kyselypalvelu.domain.Survey;
import com.example.kyselypalvelu.domain.SurveyRepository;

@Controller
public class SurveyController {


	@Autowired
	private SurveyRepository srepository;
	
	
	// API doc
	@RequestMapping(value = "/apidoc", method = RequestMethod.GET)
	public String apiDoc() {
		return "apidoc";
	}

	
	@RequestMapping(value="/surveys", method=RequestMethod.GET)
	public @ResponseBody List<Survey> getSurveys(){
		return (List<Survey>) srepository.findAll();
	}
	//@RequestMapping(value="/surveys/{name}", method=RequestMethod.GET)//idis löytää nimen perusteella tietyt kyssärit tiettyyn surveyhyn
	//public @ResponseBody Survey getSurveys(@PathVariable("name")String name){
	//return srepository.findByname(name);
	//}

	@RequestMapping(value ="/surveys/{id}", method = RequestMethod.GET)
	public @ResponseBody Survey findSurveyRest(@PathVariable("id") Long surveyid) {
		return srepository.findOne(surveyid);
	}
	

	@RequestMapping(value = "/opensurvey/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
		model.addAttribute("survey", srepository.findBysurveyid(surveyId));
	    return "redirect:questionlist";
	}  

	@RequestMapping(value = "/listsurveys", method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("surveys", srepository.findAll());
		return "listsurveys";
	}
/*
	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
	public String saveSurvey(Survey survey) {
		srepository.save(survey);
		return "redirect:listsurveys";
	} */
	
	@RequestMapping(value = "/addsurvey")
	public String addSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}
	

	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
    public @ResponseBody Survey saveSurvey(@RequestBody Survey survey) {
        srepository.save(survey);
        return survey;
    }
	
}
