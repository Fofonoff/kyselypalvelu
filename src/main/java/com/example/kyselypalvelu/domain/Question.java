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
	public class Question {
		
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
		private String kysymys;
		private String questiontype;
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name="surveyid")
		private Survey survey;
		@OneToMany(cascade = CascadeType.ALL, mappedBy="question")
		private List <Answer> answers;
		@OneToMany(cascade = CascadeType.ALL, mappedBy ="question")
		private List <Option> options;
		
	

		public Question(String kysymys, String questiontype, Survey survey) {
			super();
			this.kysymys = kysymys;
			this.questiontype = questiontype;
			this.survey = survey;
		}
		
		public Question(String kysymys) {
			super();
			this.kysymys = kysymys;
		}
		
		public Question(Long id) {
			super();
			this.id = id;
		}
		
		public Question() {
			super();
		}

		public Long getId() {
			return id;
		}


		public String getKysymys() {
			return kysymys;
		}

		public Survey getSurvey() {
			return survey;
		}


		public void setId(Long id) {
			this.id = id;
		}

		public void setKysymys(String kysymys) {
			this.kysymys = kysymys;
		}


		public void setSurvey(Survey survey) {
			this.survey = survey;
		}



		public String getQuestiontype() {
			return questiontype;
		}

		public void setQuestiontype(String questiontype) {
			this.questiontype = questiontype;
		}

		public void setAnswers(List<Answer> answers) {
			this.answers = answers;
		}

		public void setOption(List<Option> option) {
			this.options = option;
		}

		public List<Answer> getAnswers() {
			return answers;
		}

		public List<Option> getOption() {
			return options;
		}

		@Override
		public String toString() {
			return "Question [id=" + id + ", kysymys=" + kysymys + ", questiontype=" + questiontype + ", survey="
					+ survey + ", answers=" + answers + ", option=" + options + "]";
		}

		
	
}
