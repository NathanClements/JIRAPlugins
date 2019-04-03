package com.atlassian.plugins.tutorial.refapp;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.net.URI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyPluginServlet
{
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_CONNECTION = "jdbc:h2:D:\\Atlassian\\Application Data\\JIRA\\database\\h2db";
	private static final String DATABASE_USER = "sa";
	private static final String DATABASE_PASSWORD = "";
	
	
	public static void main(String[] args)
	{
		readDBTable();
	}
	
	public static void readDBTable()
	{
		Connection connection = getDBConnection();
		try
		{
			connection.close();
		}
		catch (SQLException ex)
		{
			System.out.println(ex.toString());
		}
	}
	
	private static Connection getDBConnection()
	{
		Connection H2DBConnection = null;
		System.out.println("Starting Connection");
		try
		{
			Class.forName(DATABASE_DRIVER);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex.toString());
		}
		try
		{
			H2DBConnection = DriverManager.getConnection(DATABASE_CONNECTION, DATABASE_USER, DATABASE_PASSWORD);
			System.out.println("Connection Made");
			return H2DBConnection;
		}
		catch (SQLException ex)
		{
			System.out.println(ex.toString());
		}
		
		return H2DBConnection;
	}


}