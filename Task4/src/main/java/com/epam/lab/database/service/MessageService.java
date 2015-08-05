package com.epam.lab.database.service;

import java.util.List;

import com.epam.lab.database.model.Message;
import com.epam.lab.hibernate.dao.MessageDAO;


public class MessageService {
	
	public static void addMessage(Message message){
		MessageDAO.addMessage(message);
	}
	
	public static void delMessage(Integer id){
		MessageDAO.delMessage(id);
	}
	
	public static Message getMessage(Integer id){
		return MessageDAO.getMessage(id);
	}
	
	public static List<Message> getAllMessage(Integer reciver){
		return MessageDAO.getAllMessage(reciver);
	}
	

}
