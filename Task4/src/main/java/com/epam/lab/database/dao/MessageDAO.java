package com.epam.lab.database.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.Message;

import com.epam.lab.transformer.MessageTransformer;


public class MessageDAO {

	public static void addMessag(Message messag){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO message(reciver, sender,text,time,reciverlecture,senderlecture,subject) VALUES(?,?,?,?,?,?,?);");
			st.setInt(1, messag.getReciver());
			st.setInt(2, messag.getSender());
			st.setString(3, messag.getText());
			st.setTimestamp(4, new Timestamp(messag.getDate().getTime()));
		st.setBoolean(5, messag.getReciverlecture());
		st.setBoolean(6, messag.getSenderlecture());
		st.setString(7, messag.getSubject());
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
	
	public static void delMessage(Integer id){
		Connection con = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM message WHERE id=?");
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
	
	public static List<Message> getAllMessags(Integer reciver) {
		ResultSet rs = null;
		Connection con = null;
		List<Message> message = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM message WHERE reciver=?");
			st.setInt(1, reciver);
			rs = st.executeQuery();
			message =MessageTransformer.getAllMessage(rs);
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
		return message;
	}

	public static Message getMessage(Integer id) {
		ResultSet rs = null;
		Connection con = null;
		Message message = null;
		try {
			con = ConnectionManger.getConnection();
			PreparedStatement st = con
					.prepareStatement("SELECT * FROM message WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			message = MessageTransformer.getMessage(rs);
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

		return message;
	}
}
