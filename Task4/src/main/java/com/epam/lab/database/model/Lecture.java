package com.epam.lab.database.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.epam.lab.database.service.SubjectService;
@Entity
public class Lecture {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String url;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="subject_id")
	private Subject subject;
	@Column(nullable=false,columnDefinition="TINYINT(1) default '0'")
	private Boolean admin = false;
	@Column(nullable=false, columnDefinition="TINYINT(1) default '1'")
	private Boolean status = true;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSubjectName(){
		return subject.getName();
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Lecture [id=" + id + ", email=" + email + ", password="
				+ password + ", name=" + name + ", surname=" + surname
				+ ", url=" + url + ", subject=" + subject + ", admin=" + admin
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	
}
