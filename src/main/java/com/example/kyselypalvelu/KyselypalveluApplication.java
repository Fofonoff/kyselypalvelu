package com.example.kyselypalvelu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.kyselypalvelu.domain.Question;
import com.example.kyselypalvelu.domain.QuestionRepository;

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
	
	@Bean
	public CommandLineRunner questionDemo(QuestionRepository repository) {
		return (args) -> {
			log.info("Saving couple of questions");
			
			repository.save(new Question("beer", "Olut, kalja, bisse vai bini?"));
			repository.save(new Question("howAreYou", "Kuinka on päivä mennyt?"));
		};
	}
}
