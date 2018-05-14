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

import com.example.kyselypalvelu.domain.Question;
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

	@RequestMapping(value ="/surveys/{id}", method = RequestMethod.GET)
	public @ResponseBody Survey getSurveyById(@PathVariable("id") Long surveyid) {
		return srepository.findOne(surveyid);
	}
/*
	//saa postmanilla esim nyt uutta surveyta tallennettua, sotii kommentoitua metodia vastaan eli nyt ei toimi thymelead/html lisäys
	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
    public @ResponseBody Survey saveSurvey(@RequestBody Survey survey) {
        srepository.save(survey);
        return survey;
    }
	*/
	@RequestMapping(value = "/opensurvey/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") Long surveyid, Model model, Survey survey) {
		model.addAttribute("survey", srepository.findOne(surveyid));
		//Survey survey2 = srepository.findOne(surveyid);
		//System.out.println("Kysely id "+ survey2.getSurveyid());
		model.addAttribute("question", new Question());
		return "questionlist";
	}  

	@RequestMapping(value = "/listsurveys", method = RequestMethod.GET)
	public String listQuestions(Model model) {
		model.addAttribute("surveys", srepository.findAll());
		return "listsurveys";
	}
	// thymeleaf-html savetusta varten ilman requestbodya, nyt ilman tätä ei toimi!!!
	@RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
	public String saveSurvey(Survey survey) {
		srepository.save(survey);
		return "redirect:listsurveys";
	} 
	
	@RequestMapping(value = "/addsurvey")
	public String addSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "addsurvey";
	}
	
	//@RequestMapping(value="/surveys/{name}", method=RequestMethod.GET)//idis löytää nimen perusteella tietyt kyssärit tiettyyn surveyhyn
	//public @ResponseBody Survey getSurveys(@PathVariable("name")String name){
	//return srepository.findByname(name);
	//}
	
}
