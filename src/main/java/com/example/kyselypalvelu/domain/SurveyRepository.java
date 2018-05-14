package com.example.kyselypalvelu.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface SurveyRepository extends CrudRepository <Survey, Long>{

	Optional<Survey> findBysurveyid(Long surveyid);

	//Survey findOne(Long surveyid);


//isolla Surveyid tossa finby:ssa ja Optional turha??
	

}
