package com.example.kyselypalvelu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kyselypalvelu.domain.Answer;
import com.example.kyselypalvelu.domain.AnswerRepository;

public class AnswerController {

	@Autowired
	private AnswerRepository arepository;
	
	
	@RequestMapping(value="/answerlist", method=RequestMethod.GET)
	public @ResponseBody List<Answer> getAnswers(){
		return (List<Answer>) arepository.findAll();
	}
	
	@RequestMapping(value = "/answers", method = RequestMethod.POST)
    public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
        arepository.save(answer);
        return answer;
    }
	
	
	
}
