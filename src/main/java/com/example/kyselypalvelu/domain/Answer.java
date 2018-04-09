package com.example.kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long answerid;
private String answer;
@ManyToOne
@JsonIgnore
@JoinColumn(name="id")
private Question question;

private Answer (){}

private Answer(String answer){
	this.answer=answer;
}

public Long getAnswerid() {
	return answerid;
}

public String getAnswer() {
	return answer;
}

public Question getQuestion() {
	return question;
}

public void setAnswerid(Long answerid) {
	this.answerid = answerid;
}

public void setAnswer(String answer) {
	this.answer = answer;
}

public void setQuestion(Question question) {
	this.question = question;
}

@Override
public String toString() {
	return "Answer [answerid=" + answerid + ", answer=" + answer + ", question=" + question + "]";
}

}
