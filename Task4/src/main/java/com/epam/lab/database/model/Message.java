package com.epam.lab.database.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Message {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer reciver;
	private Integer sender;
	@Column(columnDefinition="TIMESTAMP")
	private Date date;
	@Column(columnDefinition="TEXT")
	private String text;
	private String subject;
	@Column(columnDefinition="TINYINT(1)")
	private Boolean reciverlecture;
	@Column(columnDefinition="TINYINT(1)")
	private Boolean senderlecture;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReciver() {
		return reciver;
	}

	public void setReciver(Integer reciver) {
		this.reciver = reciver;
	}

	public Integer getSender() {
		return sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getReciverlecture() {
		return reciverlecture;
	}

	public void setReciverlecture(Boolean reciverlecture) {
		this.reciverlecture = reciverlecture;
	}

	public Boolean getSenderlecture() {
		return senderlecture;
	}

	public void setSenderlecture(Boolean senderlecture) {
		this.senderlecture = senderlecture;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", reciver=" + reciver + ", sender="
				+ sender + ", date=" + date + ", text=" + text + ", subject="
				+ subject + ", reciverlecture=" + reciverlecture
				+ ", senderlecture=" + senderlecture + "]";
	}

	
	
}
