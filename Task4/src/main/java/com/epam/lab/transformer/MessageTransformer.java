package com.epam.lab.transformer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.lab.database.model.Message;


public class MessageTransformer {

	public static Message getMessage(ResultSet rs) {

		Message message = null;

		try {
			while (rs.next()) {
				message = new Message();
				message.setId(rs.getInt(1));
				message.setReciver(rs.getInt(2));
				message.setSender(rs.getInt(3));
				message.setText(rs.getString(4));
				message.setDate(rs.getTimestamp(5));
				message.setReciverlecture(rs.getBoolean(6));
				message.setSenderlecture(rs.getBoolean(7));
				message.setSubject(rs.getString(8));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;

	}

	public static List<Message> getAllMessage(ResultSet rs) {
		List<Message> list = new ArrayList<Message>();
		Message message = null;

		try {
			while (rs.next()) {
				message = new Message();
				message.setId(rs.getInt(1));
				message.setReciver(rs.getInt(2));
				message.setSender(rs.getInt(3));
				message.setText(rs.getString(4));
				message.setDate(rs.getTimestamp(5));
				message.setReciverlecture(rs.getBoolean(6));
				message.setSenderlecture(rs.getBoolean(7));
				message.setSubject(rs.getString(8));
				list.add(message);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
