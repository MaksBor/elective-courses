package com.epam.lab.database.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
public class Subject implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String url;
	@Column(columnDefinition="TEXT")
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", url=" + url
				+ ", description=" + description + "]";
	}
	
	
	
}
