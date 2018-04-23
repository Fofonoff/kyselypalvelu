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
		private String name;
		private String kysymys;
		private String questiontype;
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name="surveyid")
		private Survey survey;
		@OneToMany(cascade = CascadeType.ALL, mappedBy="question")
		private List <Answer> answer;
		
	

		public Question(String name, String kysymys, String questiontype, Survey survey) {
			super();
			this.name = name;
			this.kysymys = kysymys;
			this.questiontype = questiontype;
			this.survey = survey;
		}
		
		public Question(String name, String kysymys) {
			super();
			this.name = name;
			this.kysymys = kysymys;
		}
		
		public Question() {
			super();
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<Answer> getAnswer() {
			return answer;
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

		public void setName(String name) {
			this.name = name;
		}


		public void setKysymys(String kysymys) {
			this.kysymys = kysymys;
		}


		public void setSurvey(Survey survey) {
			this.survey = survey;
		}

		public void setAnswer(List<Answer> answer) {
			this.answer = answer;
		}

		public String getQuestiontype() {
			return questiontype;
		}

		public void setQuestiontype(String questiontype) {
			this.questiontype = questiontype;
		}

		@Override
		public String toString() {
			return "Question [id=" + id + ", name=" + name + ", kysymys=" + kysymys + ", questiontype=" + questiontype + ", survey="
					+ survey + ", answer=" + answer + "]";
		}
		
	
}
