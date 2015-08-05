package com.epam.lab.database.model;

public class Daybook {

	private Integer id;
	private String nameTest;
	private Integer student;
	private Integer rating;
	private Integer subject;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameTest() {
		return nameTest;
	}
	public void setNameTest(String nameTest) {
		this.nameTest = nameTest;
	}
	
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getStudent() {
		return student;
	}
	public void setStudent(Integer student) {
		this.student = student;
	}
	
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Daybook [id=" + id + ", nameTest=" + nameTest + ", student="
				+ student + ", rating=" + rating + ", subject=" + subject + "]";
	}

	
	
}
