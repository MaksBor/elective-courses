package com.epam.lab.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.Daybook;
import com.epam.lab.transformer.DaybookTransformer;



public class DaybookDAO {
	public static void addDaybook(Daybook daybook){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO daybook(nameTest,student,rating,subject) VALUES(?,?,?,?);");
			st.setString(1, daybook.getNameTest());
			st.setInt(2, daybook.getStudent());
			st.setInt(3,	daybook.getRating());
			st.setInt(4, daybook.getSubject());
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
	
	public static void delDaybook(Integer id){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM daybook WHERE id=?");
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
	
	public static void updateDaybook(Daybook daybook){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE daybook SET nameTest=?, student=?, rating=?, subject=? WHERE id=?");
			
			st.setString(1, daybook.getNameTest());
			st.setInt(2, daybook.getStudent());
			st.setInt(3, daybook.getRating());
			st.setInt(4, daybook.getSubject());
			st.setInt(5, daybook.getId());
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
	
	public static List<Daybook> getAllDaybook(){
		ResultSet rs = null;
		Connection con = null;
		List<Daybook> daybook = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM daybook");
			rs = st.executeQuery();
			daybook =DaybookTransformer.getAllDaybook(rs);
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
		return daybook;
	}
	public static Daybook getDaybook(Integer id){
		ResultSet rs = null;
		Connection con = null;
		Daybook daybook = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM daybook WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			daybook =DaybookTransformer.getDaybook(rs);
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
		
		return daybook;
	}
}
