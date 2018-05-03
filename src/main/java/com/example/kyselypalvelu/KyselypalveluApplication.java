package com.example.kyselypalvelu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.kyselypalvelu.domain.Answer;
import com.example.kyselypalvelu.domain.AnswerRepository;
import com.example.kyselypalvelu.domain.Option;
import com.example.kyselypalvelu.domain.OptionRepository;
import com.example.kyselypalvelu.domain.Question;
import com.example.kyselypalvelu.domain.QuestionRepository;
import com.example.kyselypalvelu.domain.Survey;
import com.example.kyselypalvelu.domain.SurveyRepository;

@SpringBootApplication
public class KyselypalveluApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(KyselypalveluApplication.class);
	}
	
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner questionDemo(QuestionRepository repository, SurveyRepository srepo, AnswerRepository arepo, OptionRepository orepo) {
		return (args) -> {
			log.info("Saving test Boss-survey and Inno-survey");
			Survey survey1 = srepo.save(new Survey("Boss"));
			Survey survey2 = srepo.save(new Survey("Inno"));
			
			
			log.info("Saving couple of questions");
			
			Answer answer = new Answer("Kyllä");
			Question question = new Question("Tutustuitko uusiin ihmisiin?", " ", survey1);
			repository.save(question);
			answer.setQuestion(question);
			arepo.save(answer);
			
			repository.save(new Question("Olut, kalja, bisse vai bini?", " ", survey1));
			repository.save(new Question("Kuinka on päivä mennyt?", " ", survey2));
			
			repository.save(new Question("Menitkö tapahtumiin yksin vai kavereiden kanssa?", " ", survey1));
			repository.save(question);
			
			repository.save(new Question("Mistä Helgan järjestämästä tapahtumasta olet pitänyt eniten?", " ", survey1));
			orepo.save(new Option("testi"));
		};
	}*/
	}

