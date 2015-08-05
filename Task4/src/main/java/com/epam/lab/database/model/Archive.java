package com.epam.lab.database.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Archive {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="lecture_id")
	private Lecture lector;
	private Integer rating;
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="subject_id")
	private Subject subject;
	@Temporal(TemporalType.DATE)
	private Date date;
	public Integer getId() {
		return id;
	}

	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}


	

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Lecture getLector() {
		return lector;
	}


	public void setLector(Lecture lector) {
		this.lector = lector;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Archive [id=" + id + ", student=" + student + ", lector="
				+ lector + ", rating=" + rating + ", subject=" + subject
				+ ", date=" + date + "]";
	}

	

}
