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
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name="surveyid")
		private Survey survey;
		@OneToMany(cascade = CascadeType.ALL, mappedBy="question")
		private List <Answer> answer;
		
	
<<<<<<< HEAD
		public Question(String name, String kysymys, Survey survey) {
			super();
			this.name = name;
			this.kysymys = kysymys;
			this.survey = survey;
		}
		
		public Question(String name, String kysymys) {
			super();
			this.name = name;
			this.kysymys = kysymys;
=======
		public Question(String name, String kysymys) {
			super();
			this.name = name;
			this.kysymys = kysymys;
>>>>>>> 417b47770c548f9c1b05553b92b372c7bc497d50
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

<<<<<<< HEAD
		public String getKysymys() {
			return kysymys;
		}
=======
	
>>>>>>> 417b47770c548f9c1b05553b92b372c7bc497d50

		public Survey getSurvey() {
			return survey;
		}

		
		public String getKysymys() {
			return kysymys;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

<<<<<<< HEAD
		public void setKysymys(String kysymys) {
			this.kysymys = kysymys;
		}
=======
		
>>>>>>> 417b47770c548f9c1b05553b92b372c7bc497d50

		public void setSurvey(Survey survey) {
			this.survey = survey;
		}

		public void setAnswer(List<Answer> answer) {
			this.answer = answer;
		}

		
		public void setKysymys(String kysymys) {
			this.kysymys = kysymys;
		}

		@Override
		public String toString() {
<<<<<<< HEAD
			return "Question [id=" + id + ", name=" + name + ", kysymys=" + kysymys + ", survey=" + survey + "]";
=======
			return "Question [id=" + id + ", name=" + name + ", kysymys=" + kysymys + ", survey=" + survey + ", answer="
					+ answer + "]";
>>>>>>> 417b47770c548f9c1b05553b92b372c7bc497d50
		}
			
}
