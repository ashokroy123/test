package com.app.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	public static Connection getConnect() {
		Connection con=null;
		InputStream inStream =null;
		Properties props=new Properties();
		try {
			 
			inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties");
			props.load(inStream);
			Class.forName(props.getProperty("DB_DRIVER_NAME"));
			con=DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USER_NAME"),props.getProperty("DB_PASSWORD"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection con){
		try {
			if(con !=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
