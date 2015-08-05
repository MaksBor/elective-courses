package com.epam.lab.database.service;

import java.util.List;

import com.epam.lab.database.model.ClassRoom;
import com.epam.lab.hibernate.dao.ClassDAO;


public class ClassService {
	public static void addClassRoom(ClassRoom classRoom) {
		ClassDAO.addClass(classRoom);
	}

	public static void delClassRoom(Integer subject) {
		ClassDAO.delClassRoom(subject);
	}

	public static void updateClassRoom(ClassRoom classRoom) {
		ClassDAO.updateClassRoom(classRoom);
	}

	public static List<ClassRoom> getAllClassRoom() {
		return ClassDAO.getAllClassRoom();
	}

	public static ClassRoom getClassRoom(Integer id) {
		return ClassDAO.getClass(id);
	}
	public static void delStudentClassRoom(Integer idStudent, Integer idCourse){
		 ClassDAO.delStudentClassRoom(idStudent, idCourse);
	}
	public static List<ClassRoom> getAllClassRoomForStudent(Integer IdStudent){
		return ClassDAO.getAllClassRoomForStudent(IdStudent);
	}
	public static List<ClassRoom> getAllClassRoomForLecurer(Integer IdLecturer){
		return ClassDAO.getAllClassRoomForLecurer(IdLecturer);
	}
	public static void delClassRoomID(Integer id) {
		ClassDAO.deleteClassRoom(id);
	}
}
