package com.rhiodamuthie.user.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/java_jdbc_basics";
		String user = "root";
		String pass = "";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url, user, pass)) {
		    System.out.println("Database connected!");
		    
		    Statement statement = connection.createStatement();
//			Statement statement = conn.createStatement();
			System.out.println(statement);
			int result = statement.executeUpdate("insert into user values ('firstname','lastname','email','password')");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}

	}

}
