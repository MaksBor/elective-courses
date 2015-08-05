package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.Subject;



public class SubjectTransormer {
	public static Subject getSubject(ResultSet rs) {

		Subject subject = null;

		try {
			while (rs.next()) {
				subject = new Subject();
				subject.setId(rs.getInt(1));
				subject.setName(rs.getString(2));
				subject.setUrl(rs.getString(3));
				subject.setDescription(rs.getString(4));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;

	}

	public static List<Subject> getAllSubject(ResultSet rs) {
		List<Subject> list = new ArrayList<Subject>();
		Subject subject = null;

		try {
			while (rs.next()) {
				subject = new Subject();
				subject.setId(rs.getInt(1));
				subject.setName(rs.getString(2));
				subject.setUrl(rs.getString(3));
				subject.setDescription(rs.getString(4));
				list.add(subject);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
