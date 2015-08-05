package com.epam.lab.conector;
import java.sql.*;

import javax.naming.*;
import javax.sql.*;

import com.epam.lab.log.MyLogger;



public class ConnectionManger {

private static InitialContext ic;
private static DataSource ds;
	private ConnectionManger(){
		
	}
	
	public static Connection getConnection() throws SQLException{
		if(ds== null){
			try {
				ic = new InitialContext();
				ds = (DataSource) ic.lookup("java:/comp/env/jdbc/my_database");
				
				
			} catch (NamingException e ) {
				
				MyLogger.log.error(e);
			}
		}
		
		
		return  ds.getConnection();
		
		
	} 
	public static void close(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				MyLogger.log.error(e);
			}
		}
	}


}
