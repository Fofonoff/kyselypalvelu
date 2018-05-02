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
import com.example.kyselypalvelu.domain.Option;
import com.example.kyselypalvelu.domain.OptionRepository;
import com.example.kyselypalvelu.domain.Question;

@Controller
public class AnswerController {

	@Autowired
	private AnswerRepository arepository;
	@Autowired
	private OptionRepository orepository;
	
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public @ResponseBody List<Answer> getAnswers(){
		return (List<Answer>) arepository.findAll();
	}
	
	@RequestMapping(value="/answers/{id}", method=RequestMethod.GET)
	public @ResponseBody Answer getAnswerById(@PathVariable("id") Long answerId){
		return arepository.findOne(answerId);
	}
	
	@RequestMapping(value = "/saveanswer/{questionid}", method = RequestMethod.POST)
    public @ResponseBody Answer saveAnswer(@RequestBody Answer answer, @PathVariable("questionid") Long questionid) {
        answer.setQuestion(new Question(questionid));
		arepository.save(answer);
        return answer;
    }
	@RequestMapping(value = "/saveoption/{questionid}", method = RequestMethod.POST)
    public @ResponseBody Option saveOptionToQuestion(@RequestBody Option option, @PathVariable("questionid") Long questionid) {
        option.setQuestion(new Question(questionid));
		orepository.save(option);
        return option;
	}
	
	@RequestMapping(value = "/saveoptionanswer/{optionid}", method = RequestMethod.POST)
    public @ResponseBody Answer saveOptionToAnswer(@PathVariable("optionid")List<Option> optionid){
			Answer answer = arepository.save(new Answer());
			answer.setOption(optionid);
			arepository.save(answer);
        return answer;
	}
}
