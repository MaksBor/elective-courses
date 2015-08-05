package com.epam.lab.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.Student;
import com.epam.lab.transformer.StudentTransformer;

public class StudentDAO {

	public static void addStudent(Student student) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("INSERT INTO student(email,password,name,surname,country,adress,gender,date,url) VALUES(?,?,?,?,?,?,?,?,?);");
			st.setString(1, student.getEmail());
			st.setString(2, student.getPassword());
			st.setString(3, student.getName());
			st.setString(4, student.getSurname());
			st.setString(5, student.getCountry());
			st.setString(6, student.getAdress());
			st.setString(7, student.getGender());
			st.setDate(8, new Date(student.getDate().getTime()));
			st.setString(9, student.getUrl());
			
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

	public static void delStudent(Integer id) {
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("DELETE FROM student WHERE id=?");
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

	public static void updateStudent(Student student) {

		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("UPDATE student SET password=?, name=?, surname=?, country=?,  adress=?, gender=?, date=?, url=?, status=?, verificate=? WHERE id=?");

			st.setString(1, student.getPassword());
			st.setString(2, student.getName());
			st.setString(3, student.getSurname());
			st.setString(4, student.getCountry());
			st.setString(5, student.getAdress());
			st.setString(6, student.getGender());
			st.setDate(7, (Date) student.getDate());
			st.setString(8, student.getUrl());
			st.setBoolean(9, student.getStatus());
			st.setBoolean(10, student.getVerificate());
			st.setInt(11, student.getId());
			
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

	public static List<Student> getAllStudent() {
		ResultSet rs = null;
		Connection con = null;
		List<Student> student = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM student");
			rs = st.executeQuery();
			student = StudentTransformer.getAllStudent(rs);
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
		return student;
	}

	public static List<Student> getAllStudentSearch(String shearch) {
		ResultSet rs = null;
		Connection con = null;
		List<Student> student = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM student WHERE name=? or surname=? or email=? or country=? or adress=? or gender=?");
			st.setString(1, shearch);
			st.setString(2, shearch);
			st.setString(3, shearch);
			st.setString(4, shearch);
			st.setString(5, shearch);
			st.setString(6, shearch);
			rs = st.executeQuery();
			student = StudentTransformer.getAllStudent(rs);
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
		return student;
	}
	
	
	public static Student getStudent(Integer id) {
		ResultSet rs = null;
		Connection con = null;
		Student student = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM student WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			student = StudentTransformer.getStudent(rs);
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

		return student;
	}

	public static Student getStudent(String email) {
		ResultSet rs = null;
		Connection con = null;
		Student student = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM student WHERE email=?");
			st.setString(1, email);
			rs = st.executeQuery();
			student = StudentTransformer.getStudent(rs);
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

		return student;
	}
}
