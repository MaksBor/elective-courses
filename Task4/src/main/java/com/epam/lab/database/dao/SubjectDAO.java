package com.epam.lab.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.Subject;
import com.epam.lab.transformer.SubjectTransormer;

public class SubjectDAO {
	public static void addSubject(Subject subject){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO subject(name, url,description) VALUES(?,?,?);");
			st.setString(1, subject.getName());
			st.setString(2, subject.getUrl());
			st.setString(3, subject.getDescription());
			st.executeUpdate();
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
	}
	
	public static void delSubject(Integer id){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM subject WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();
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
	}
	
	public static void updateSubject(Subject subject){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE subject SET name=?, url=?, description=? WHERE id=?");
			
			
			st.setString(1, subject.getName());
			st.setString(2, subject.getUrl());
			st.setString(3, subject.getDescription());
			st.setInt(3, subject.getId());
			st.executeUpdate();
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
	}
	
	public static List<Subject> getAllSubject(){
		ResultSet rs = null;
		Connection con = null;
		List<Subject> subject = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM subject");
			rs = st.executeQuery();
			subject = SubjectTransormer.getAllSubject(rs);
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
		return subject;
	}
	public static Subject getSubject(Integer id){
		ResultSet rs = null;
		Connection con = null;
		Subject subject = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM subject WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			subject = SubjectTransormer.getSubject(rs);
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
		
		return subject;
	}
	public static Subject getSubject(String subject){
		ResultSet rs = null;
		Connection con = null;
		Subject subjec = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM subject WHERE name=?");
			st.setString(1, subject);
			rs = st.executeQuery();
			subjec =SubjectTransormer.getSubject(rs);
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
		
		return subjec;
	}
}
