package com.royal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
	// 1. Make credentails
	private static final String URLNAME     ="jdbc:mysql://localhost:3306/nakshidb";
	private static final String DRIVERCLASS ="com.mysql.cj.jdbc.Driver";
	private static final String USERNAME    ="root";
	private static final String PASSWORD	="root";	

	public static Connection getConnection() 
	{
		Connection conn = null;
		try 
		{
			// 2.Load DriverClass
			Class.forName(DRIVERCLASS);

			// 3. pass credentials into DriverManager's getConnection method
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
		
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
//	public static void main(String[] args) 
//	{
//		Connection conn = DbConnection.getConnection();
//		System.out.println("conn : " + conn);
//		
//	}
}
