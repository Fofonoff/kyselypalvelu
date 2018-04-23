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
import com.example.kyselypalvelu.domain.Question;
import com.example.kyselypalvelu.domain.QuestionRepository;


@Controller
public class QuestionController<Survey> {

	@Autowired
	private QuestionRepository repository;
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
	//ehkä oma answerController vielä tehtävää??
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public @ResponseBody List<Answer> getAnswers(){
		return (List<Answer>) arepository.findAll();
	}
	
	@RequestMapping(value = "/savequestion", method = RequestMethod.POST)
	public String saveQuestion(Question question) {
		repository.save(question);
		return "redirect:addsurvey";
	}

	@RequestMapping(value = "/saveanswer", method = RequestMethod.POST)
    public @ResponseBody Answer saveAnswer(@RequestBody Answer answer) {
        arepository.save(answer);
        return answer;
    }
	
}
