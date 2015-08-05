package com.epam.lab.database.service;

import java.util.List;



import com.epam.lab.database.model.Lecture;
import com.epam.lab.hibernate.dao.LectureDAO;

public class LectureService {

	public static void addLecture(Lecture lecture) {
		LectureDAO.addLecture(lecture);
	}

	public static void delLecture(Integer id) {
		LectureDAO.deleteLecture(id);
	}

	public static void updateLecture(Lecture lecture) {
		LectureDAO.updateLecture(lecture);
	}

	public static List<Lecture> getAllLecture() {
		return LectureDAO.getAllLecture();
	}

	public static Lecture getLectureSubject(Integer id) {
		return LectureDAO.getLectureSubject(id);
	}
	public static Lecture getLecture(Integer id) {
		return LectureDAO.getLecture(id);
	}
	public static Lecture getLecture(String email) {
		return LectureDAO.getLecture(email);
	}
	public static List<Lecture> getAllLectureSearch(String search){
		return LectureDAO.getAllLectureSearch(search);
	}
}

