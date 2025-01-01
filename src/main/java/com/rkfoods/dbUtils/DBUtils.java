package com.rkfoods.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DBUtils {
	private static String url="jdbc:mysql://localhost:3306/rkfoods";
	private static String username="root";
	private static String password="root";
	private static Connection con=null;
	
	public static  Connection myConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		  con=	DriverManager.getConnection(url,username,password);
			
		}	
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
}
