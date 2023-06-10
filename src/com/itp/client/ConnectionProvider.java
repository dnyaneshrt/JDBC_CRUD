package com.itp.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	static Connection con=null;
	public static Connection getConnection()
	{
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		String url="jdbc:mysql://localhost:3306/sakila";
		String user="root";
		String password="root";
		try {
			con=DriverManager.getConnection(url, user, password);
			if(con!=null)
			{
				System.out.println("connection created successfully..");
			}else
			{
				System.out.println("failed to create the connection..");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}

}
