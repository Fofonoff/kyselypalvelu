package com.example.kyselypalvelu.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Question {
		
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
		
		private String name;
		private String question;
		
		public Question(String name, String question) {
			super();
			this.name = name;
			this.question = question;
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

		public String getQuestion() {
			return question;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		@Override
		public String toString() {
			return "Kysymys [id=" + id + ", name=" + name + ", question=" + question + "]";
		}
			
}
