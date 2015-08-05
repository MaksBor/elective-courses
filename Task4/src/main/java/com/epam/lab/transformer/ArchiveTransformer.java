/*package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.Archive;


public class ArchiveTransformer {

	public static Archive getArchive(ResultSet rs) {

		Archive archive = null;

		try {
			while (rs.next()) {
				archive = new Archive();
				archive.setId(rs.getInt(1));
				archive.setSubject(rs.getInt(2));
				archive.setRating(rs.getInt(3));
				archive.setStudent(rs.getInt(4));
				archive.setLector(rs.getInt(5));
				archive.setDate(rs.getDate(6));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return archive;

	}

	public static List<Archive> getAllArchive(ResultSet rs) {
		List<Archive> list = new ArrayList<Archive>();
		Archive archive = null;

		try {
			while (rs.next()) {
				archive = new Archive();
				archive.setId(rs.getInt(1));
				archive.setSubject(rs.getInt(2));
				archive.setRating(rs.getInt(3));
				archive.setStudent(rs.getInt(4));
				archive.setLector(rs.getInt(5));
				archive.setDate(rs.getDate(6));
				list.add(archive);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
*/