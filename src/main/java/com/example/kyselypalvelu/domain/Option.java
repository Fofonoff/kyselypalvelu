package com.example.kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Option {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long optionid;
private String text;
@ManyToOne
@JsonIgnore
@JoinColumn(name="id")
private Question question;
@ManyToMany(cascade = CascadeType.ALL, mappedBy="option")
@JsonIgnore
private List <Answer> answer;


	public Option (){}
	
	public Option (String text) {
		this.text = text;
	}

	public Long getOptionid() {
		return optionid;
	}

	public String getText() {
		return text;
	}

	public Question getQuestion() {
		return question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setOptionid(Long optionid) {
		this.optionid = optionid;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Option [optionid=" + optionid + ", text=" + text + ", question=" + question + ", answer=" + answer
				+ "]";
	}
	
}
