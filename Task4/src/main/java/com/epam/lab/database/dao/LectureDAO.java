/*package com.epam.lab.database.dao;


import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.Lecture;
import com.epam.lab.transformer.lecturerTransformer;


public class LectureDAO {
	public static void addLecture(Lecture lecture){
		Connection con =null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO lecturer(email,password,name,surname,subject,url) VALUES(?,?,?,?,?,?);");
			st.setString(1, lecture.getEmail());
			st.setString(2, lecture.getPassword());
			st.setString(3,	lecture.getName());
			st.setString(4, lecture.getSurname());
			st.setInt(5, lecture.getSubject());
			st.setString(6, lecture.getUrl());
		
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
	}
	
	public static void delLecture(Integer id){
		Connection con =null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM lecturer WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void updateLecture(Lecture lecture){
		Connection con =null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE lecturer SET password=?, name=?, surname=?, subject=?, url=?, admin=?, status=? WHERE id=?");
			
			st.setString(1, lecture.getPassword());
			st.setString(2, lecture.getName());
			st.setString(3, lecture.getSurname());
			if(lecture.getSubject()==null){
				st.setNull(4, Types.NULL);
			}
			else{
				st.setInt(4, lecture.getSubject());
			}
			
			st.setString(5, lecture.getUrl());
			st.setBoolean(6, lecture.getAdmin());
			st.setBoolean(7, lecture.getStatus());
			st.setInt(8, lecture.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static List<Lecture> getAllLecture(){
		ResultSet rs = null;
		Connection con =null;
		List<Lecture> lecture =null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM lecturer");
			rs = st.executeQuery();
			lecture =lecturerTransformer.getAllLecture(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lecture;
	}
	
	public static List<Lecture> getAllLectureSearch(String search){
		ResultSet rs = null;
		Connection con =null;
		List<Lecture> lecture =null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM lecturer Where name=? or surname=? or email=?");
			st.setString(1, search);
			st.setString(2, search);
			st.setString(3, search);
			rs = st.executeQuery();
			lecture =lecturerTransformer.getAllLecture(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lecture;
	}
	public static Lecture getLectureSubject(Integer id){
		ResultSet rs = null;
		Connection con =null;
		Lecture lecture = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM lecturer WHERE subject=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			lecture=lecturerTransformer.getLecture(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lecture;
	}
	public static Lecture getLecture(Integer id){
		ResultSet rs = null;
		Connection con =null;
		Lecture lecture = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM lecturer WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			lecture=lecturerTransformer.getLecture(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return lecture;
	}
	public static Lecture getLecture(String email){
		ResultSet rs = null;
		Connection con =null;
		Lecture lecture = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM lecturer WHERE email=?");
			st.setString(1, email);
			rs = st.executeQuery();
			lecture = lecturerTransformer.getLecture(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return lecture;
	}
	
}
*/