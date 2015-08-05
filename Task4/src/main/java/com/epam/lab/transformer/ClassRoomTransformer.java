/*package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.ClassRoom;


public class ClassRoomTransformer {

	public static ClassRoom getClassRoom(ResultSet rs) {

		ClassRoom classRoom = null;

		try {
			while (rs.next()) {
				classRoom = new ClassRoom();
				classRoom.setId(rs.getInt(1));
				classRoom.setStudent(rs.getInt(2));
				classRoom.setLector(rs.getInt(3));
				classRoom.setSubject(rs.getInt(4));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classRoom;

	}

	public static List<ClassRoom> getAllClassRoom(ResultSet rs) {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		ClassRoom classRoom = null;

		try {
			while (rs.next()) {
				classRoom = new ClassRoom();
				classRoom.setId(rs.getInt(1));
				classRoom.setStudent(rs.getInt(2));
				classRoom.setLector(rs.getInt(3));
				classRoom.setSubject(rs.getInt(4));
				list.add(classRoom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
*/