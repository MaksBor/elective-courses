/*package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.Lecture;


public class lecturerTransformer {
	public static Lecture getLecture(ResultSet rs) {

		Lecture lecture = null;

		try {
			while (rs.next()) {
				lecture = new Lecture();
				lecture.setId(rs.getInt(1));
				lecture.setEmail(rs.getString(2));
				lecture.setPassword(rs.getString(3));
				lecture.setName(rs.getString(4));
				lecture.setSurname(rs.getString(5));
				lecture.setSubject(rs.getInt(6));
				lecture.setUrl(rs.getString(7));
				lecture.setAdmin(rs.getBoolean(8));
				lecture.setStatus(rs.getBoolean(9));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecture;

	}

	public static List<Lecture> getAllLecture(ResultSet rs) {
		List<Lecture> list = new ArrayList<Lecture>();
		Lecture lecture = null;

		try {
			while (rs.next()) {
				lecture = new Lecture();
				lecture.setId(rs.getInt(1));
				lecture.setEmail(rs.getString(2));
				lecture.setPassword(rs.getString(3));
				lecture.setName(rs.getString(4));
				lecture.setSurname(rs.getString(5));
				lecture.setSubject(rs.getInt(6));
				lecture.setUrl(rs.getString(7));
				lecture.setAdmin(rs.getBoolean(8));
				lecture.setStatus(rs.getBoolean(9));
				list.add(lecture);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
*/