package com.epam.lab.database.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ClassRoom {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="student_id")
	private Student student;
	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="lector_id")
	private Lecture lector;
	@OneToOne(cascade= CascadeType.MERGE)
	@JoinColumn(name="subject_id")
	private Subject subject;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Class [id=" + id + ", student=" + student + ", lector="
				+ lector + ", subject=" + subject + "]";
	};
	
	
}
