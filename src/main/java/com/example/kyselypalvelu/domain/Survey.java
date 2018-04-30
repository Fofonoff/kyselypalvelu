package com.example.kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Survey {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long surveyid;
private String name;
@OneToMany(cascade= CascadeType.ALL, mappedBy="survey")
private List <Question> questions;
@ManyToOne
@JsonIgnore
@JoinColumn(name = "userid")
private User user;

public Survey(){}

public Survey(String name){
	super();
	this.name=name;
}

public Survey(Long surveyid){
	super();
	this.surveyid = surveyid;
}

public Long getSurveyid() {
	return surveyid;
}

public String getName() {
	return name;
}

public List<Question> getQuestions() {
	return questions;
}

public void setSurveyid(Long surveyid) {
	this.surveyid = surveyid;
}

public void setName(String name) {
	this.name = name;
}

public void setQuestion(List<Question> questions) {
	this.questions = questions;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "Survey [surveyid=" + surveyid + ", name=" + name + ", questions=" + questions + "]";
}

}
