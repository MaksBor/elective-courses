package com.epam.lab.database.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.CascadeType;
import org.hibernate.annotations.Cascade;

import com.epam.lab.database.service.ClassService;
@Entity
@Table(name="Student")
public class Student implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition="VARCHAR(50)")
	private String email;
	@Column(columnDefinition="VARCHAR(255)")
	private String password;
	@Column(columnDefinition="VARCHAR(50)")
	private String name;
	@Column(columnDefinition="VARCHAR(55)")
	private String surname;
	@Column(columnDefinition="VARCHAR(55)")
	private String country;
	@Column(columnDefinition="VARCHAR(255)")
	private String adress;
	@Column(name="gender", columnDefinition="VARCHAR(10)")
	private Gender gender;
	@Column(columnDefinition="DATE")
	private Date date;
	@Column(columnDefinition="VARCHAR(255)")
	private String url;
	@Column(name="status", nullable = false,columnDefinition="tinyint(1) DEFAULT '1'")
	private Boolean status;
	@Column( nullable = false,columnDefinition="tinyint(1) DEFAULT '0'")
	private Boolean verificate;
	public Student() {
		status = true;
		verificate = false;
	}
	public int getId() {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender.name().toLowerCase();
	}

	public void setGender(String gender) {
		try {
			this.gender = Gender.valueOf(gender.toUpperCase());
		} catch (IllegalArgumentException e) {

		}

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public enum Gender {
		MALE, FAMALE;
	}

	public boolean isStudyCours(int id){
		List<ClassRoom> list= ClassService.getAllClassRoom();
		for (ClassRoom classRoom : list) {
			if (classRoom.getStudent().getId()==getId()) {
				if(classRoom.getSubject().getId()== id){
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	public Boolean getVerificate() {
		return verificate;
	}

	public void setVerificate(Boolean verificate) {
		this.verificate = verificate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", password="
				+ password + ", name=" + name + ", surname=" + surname
				+ ", country=" + country + ", adress=" + adress + ", gender="
				+ gender + ", date=" + date + ", url=" + url + ", status="
				+ status + ", verificate=" + verificate + "]";
	}

	

	

}
