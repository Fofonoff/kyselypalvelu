package com.example.kyselypalvelu.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long userid;

private String name;
private String password;
private String role;
@OneToMany(cascade= CascadeType.ALL, mappedBy = "user")
private List <Survey> survey;
	
public User () {}

public User (String name, String password, String role){
	this.name=name;
	this.password=password;
	this.role=role;
}

public Long getUserid() {
	return userid;
}

public String getName() {
	return name;
}

public String getPassword() {
	return password;
}

public String getRole() {
	return role;
}

public List<Survey> getSurvey() {
	return survey;
}

public void setUserid(Long userid) {
	this.userid = userid;
}

public void setName(String name) {
	this.name = name;
}

public void setPassword(String password) {
	this.password = password;
}

public void setRole(String role) {
	this.role = role;
}

public void setSurvey(List<Survey> survey) {
	this.survey = survey;
}

@Override
public String toString() {
	return "User [userid=" + userid + ", name=" + name + ", password=" + password + ", role=" + role + ", survey="
			+ survey + "]";
}

}
