package com.epam.lab.database.service;

import java.util.List;



import com.epam.lab.database.model.Student;
import com.epam.lab.hibernate.dao.StudentDAO;


public class StudentService {

	public static void addStudent(Student st){
		
		StudentDAO.addStudent(st);
	}
	
	public static void delStudent(Integer id){
		StudentDAO.deleteStudent(id);
	}
	public static void updateStudent(Student student){
		StudentDAO.updateStudent(student);
	}
	
	public static List<Student> getAllStudent(){
		return StudentDAO.getAllStudent();
	}
	public static Student getStudent(Integer id){
		return StudentDAO.getStudent(id);
	}
	public static Student getStudent(String email){
		return StudentDAO.getStudent(email);
	}
	public static List<Student> getAllStudentSearch(String shearch) {
		return StudentDAO.getAllStudentSearch(shearch);
	}
}
