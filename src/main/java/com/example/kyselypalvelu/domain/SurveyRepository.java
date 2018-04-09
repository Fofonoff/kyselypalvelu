package com.example.kyselypalvelu.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface SurveyRepository extends CrudRepository <Survey, Long>{

	Optional<Survey> findById(Long surveyid);

}
