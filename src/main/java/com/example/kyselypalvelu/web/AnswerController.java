package com.example.kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselypalvelu.domain.Answer;
import com.example.kyselypalvelu.domain.AnswerRepository;

@Controller
public class AnswerController {

	@Autowired
	private AnswerRepository arepository;
	
	
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public @ResponseBody List<Answer> getAnswers(){
		return (List<Answer>) arepository.findAll();
	}
	
	@RequestMapping(value="/answers/{id}", method=RequestMethod.GET)
	public @ResponseBody Answer getOneAnswer(@PathVariable("id") Long answerId){
		return arepository.findOne(answerId);
	}
	
	@RequestMapping(value = "/saveanswer", method = RequestMethod.POST)
    public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
        arepository.save(answer);
        return answer;
    }
	
}
