package com.rhiodamuthie.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/java_jdbc_basics";
		String user = "root";
		String pass ="";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println(connection);
			
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into account values (1,123231231,'muthie' , 'rhioda' , 100000)");
			System.out.println(result + " row has been inserted..");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
