package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.Daybook;

public class DaybookTransformer {
	public static Daybook getDaybook(ResultSet rs) {

		Daybook daybook = null;

		try {
			while (rs.next()) {
				daybook = new Daybook();
				daybook.setId(rs.getInt(1));
				daybook.setNameTest(rs.getString(2));
				daybook.setStudent(rs.getInt(3));
				daybook.setRating(rs.getInt(4));
				daybook.setSubject(rs.getInt(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daybook;

	}

	public static List<Daybook> getAllDaybook(ResultSet rs) {
		List<Daybook> list = new ArrayList<Daybook>();
		Daybook daybook = null;

		try {
			while (rs.next()) {
				daybook = new Daybook();
				daybook.setId(rs.getInt(1));
				daybook.setNameTest(rs.getString(2));
				daybook.setStudent(rs.getInt(3));
				daybook.setRating(rs.getInt(4));
				daybook.setSubject(rs.getInt(5));
				list.add(daybook);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
