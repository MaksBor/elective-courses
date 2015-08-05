package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.Student;

public class StudentTransformer {
	public static Student getStudent(ResultSet rs) {

		Student st = null;

		try {
			while (rs.next()) {
				st = new Student();
				st.setId(rs.getInt(1));
				st.setEmail(rs.getString(2));
				st.setPassword(rs.getString(3));
				st.setName(rs.getString(4));
				st.setSurname(rs.getString(5));
				st.setCountry(rs.getString(6));
				st.setAdress(rs.getString(7));
				st.setGender(rs.getString(8));
				st.setDate(rs.getDate(9));
				st.setUrl(rs.getString(10));
				st.setStatus(rs.getBoolean(11));
				st.setVerificate(rs.getBoolean(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;

	}

	public static List<Student> getAllStudent(ResultSet rs) {
		List<Student> list = new ArrayList<Student>();
		Student st = null;

		try {
			while (rs.next()) {
				st = new Student();
				st.setId(rs.getInt(1));
				st.setEmail(rs.getString(2));
				st.setPassword(rs.getString(3));
				st.setName(rs.getString(4));
				st.setSurname(rs.getString(5));
				st.setCountry(rs.getString(6));
				st.setAdress(rs.getString(7));
				st.setGender(rs.getString(8));
				st.setDate(rs.getDate(9));
				st.setUrl(rs.getString(10));
				st.setStatus(rs.getBoolean(11));
				st.setVerificate(rs.getBoolean(12));
				list.add(st);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
