package com.example.kyselypalvelu.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long answerid;
private String vastaus;
@ManyToOne
@JsonIgnore
@JoinColumn(name="id")
private Question question;
@ManyToMany
private List <Option> option;


public Answer (){}

public Answer(String vastaus){
	this.vastaus=vastaus;
}

public Answer(Long answerid) {
	super();
	this.answerid = answerid;
}

public Long getAnswerid() {
	return answerid;
}

public String getVastaus() {
	return vastaus;
}

public Question getQuestion() {
	return question;
}

public void setAnswerid(Long answerid) {
	this.answerid = answerid;
}


public void setAnswer(String vastaus) {
	this.vastaus = vastaus;
}


public void setQuestion(Question question) {
	this.question = question;
}



public void setVastaus(String vastaus) {
	this.vastaus = vastaus;
}

public void setOption(List<Option> option) {
	this.option = option;
}

public List<Option> getOption() {
	return option;
}

@Override
public String toString() {
	return "Answer [answerid=" + answerid + ", vastaus=" + vastaus + ", question=" + question + ", option=" + option
			+ "]";
}

}
