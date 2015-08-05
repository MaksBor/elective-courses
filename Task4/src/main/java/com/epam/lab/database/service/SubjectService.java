package com.epam.lab.database.service;

import java.util.List;

import com.epam.lab.database.model.Subject;
import com.epam.lab.hibernate.dao.SubjectDAO;

public class SubjectService {

	public static void addSubject(Subject subject){
		SubjectDAO.addSubject(subject);
	}
	
	public static void delSubject(Integer id){
		SubjectDAO.deleteSubject(id);
	}
	
	public static Subject getSubject(Integer id){
		return SubjectDAO.getSubject(id);
	}
	
	public static List<Subject> getAllSubject(){
		return SubjectDAO.getAllSubject();
	}
	
	public static void updateSubject(Subject subject){
		SubjectDAO.updateSabject(subject);
	}
	public static Subject getSubject(String subject){
		return SubjectDAO.getSubject(subject);
	}
}
