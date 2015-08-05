/*package com.epam.lab.database.dao;

import java.sql.*;
import java.util.List;

import com.epam.lab.conector.ConnectionManger;
import com.epam.lab.database.model.Archive;
import com.epam.lab.log.MyLogger;
import com.epam.lab.transformer.ArchiveTransformer;


public class ArchiveDAO {
	public static void addArchive(Archive archive){
		Connection con = null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("INSERT INTO archive(subject,rating,student,lector,date) VALUES(?,?,?,?,?);");
			st.setInt(1,archive.getSubject());
			st.setInt(2, archive.getRating());
			st.setInt(3, archive.getStudent());
			st.setInt(4, archive.getLector());
			st.setDate(5, new Date(archive.getDate().getTime()));
			st.executeUpdate();
		} catch (SQLException e) {
			MyLogger.log.error(e);
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		} 
	}
	
	public static void delArchive(Integer id){
		Connection con = null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("DELETE FROM archive WHERE id=?");
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			MyLogger.log.error(e);
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		}
	}
	
	public static void updateArchive(Archive archive){
		Connection con = null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE archive SET subject=?, rating=?, student=?, lecture=?, date=? WHERE id=?");
			
			st.setInt(1, archive.getSubject());
			st.setInt(2, archive.getRating());
			st.setInt(3, archive.getStudent());
			st.setInt(4, archive.getStudent());
			st.setDate(5, new Date(archive.getDate().getTime()));
			st.setInt(6, archive.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			MyLogger.log.error(e);
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		}
	}
	
	public static List<Archive> getAllArchive(){
		ResultSet rs = null;
		Connection con = null;
		List<Archive> list = null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM archive");
			rs = st.executeQuery();
			list =ArchiveTransformer.getAllArchive(rs);
		} catch (SQLException e) {
			MyLogger.log.error(e);
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		}
		return list;
	}
	public static Archive getArchive(Integer id){
		ResultSet rs = null;
		Connection con = null;
		Archive archive =null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM archive WHERE id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			archive= ArchiveTransformer.getArchive(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		}
		
		return archive;
	}
	
	public static List<Archive> getAllArchiveStudetn(Integer idStudent){
		ResultSet rs = null;
		Connection con = null;
		List<Archive> list = null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM archive WHERE student=?");
			st.setInt(1, idStudent);
			rs = st.executeQuery();
			list =ArchiveTransformer.getAllArchive(rs);
		} catch (SQLException e) {
			MyLogger.log.error(e);
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		}
		return list;
		
	}
	public static List<Archive> getAllArchiveLecture(Integer idLector){
		ResultSet rs = null;
		Connection con = null;
		List<Archive> list = null;
		try {
			con =ConnectionManger.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM archive WHERE lector=?");
			st.setInt(1, idLector);
			rs = st.executeQuery();
			list =ArchiveTransformer.getAllArchive(rs);
		} catch (SQLException e) {
			MyLogger.log.error(e);
		}finally{
			if(con!=null){
				try {
				
					con.close();

				} catch (SQLException e) {
					MyLogger.log.error(e);
				}
			}
		}
		return list;
	}
	
}
*/