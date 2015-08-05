/*package com.epam.lab.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.ClassRoom;
import com.epam.lab.transformer.ClassRoomTransformer;

public class ClassDAO {

	public static void addClass(ClassRoom classRoom) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("INSERT INTO class(student,lector,subject) VALUES(?,?,?);");
			st.setInt(1, classRoom.getStudent());
			st.setInt(2, classRoom.getLector());
			st.setInt(3, classRoom.getSubject());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void delClassRoom(Integer subject) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("DELETE FROM class WHERE subject=?");
			st.setInt(1, subject);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void delClassRoomID(Integer id) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("DELETE FROM class WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void delStudentClassRoom(Integer idStudent, Integer idCourse) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("DELETE FROM class WHERE student=? and subject=?");
			st.setInt(1, idStudent);
			st.setInt(2, idCourse);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void updateClassRoom(ClassRoom classRoom) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("UPDATE class SET student=?, lector=?, subject=? WHERE id=?");

			st.setInt(1, classRoom.getStudent());
			st.setInt(2, classRoom.getLector());
			st.setInt(3, classRoom.getSubject());
			st.setInt(4, classRoom.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static List<ClassRoom> getAllClassRoom() {
		ResultSet rs = null;
		Connection con = null;
		List<ClassRoom> classRoom = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM class");
			rs = st.executeQuery();
			classRoom = ClassRoomTransformer.getAllClassRoom(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return classRoom;
	}

	public static ClassRoom getClassRoom(Integer id) {
		ResultSet rs = null;
		Connection con = null;
		ClassRoom clasRoom = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM class WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			clasRoom = ClassRoomTransformer.getClassRoom(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return clasRoom;
	}

	public static List<ClassRoom> getAllClassRoomForStudent(Integer IdStudent) {
		ResultSet rs = null;
		Connection con = null;
		List<ClassRoom> classRoom = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM class WHERE student=?");
			st.setInt(1, IdStudent);
			rs = st.executeQuery();
			classRoom = ClassRoomTransformer.getAllClassRoom(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return classRoom;
	}

	public static List<ClassRoom> getAllClassRoomForLecurer(Integer IdLecturer) {
		ResultSet rs = null;
		Connection con = null;
		List<ClassRoom> classRoom = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM class WHERE lector=?");
			st.setInt(1, IdLecturer);
			rs = st.executeQuery();
			classRoom = ClassRoomTransformer.getAllClassRoom(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {

					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return classRoom;
	}

}
*/