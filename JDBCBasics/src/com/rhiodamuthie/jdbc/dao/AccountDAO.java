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
			Statement statement = connection.createStatement();
			System.out.println(connection);
			
//			Statement statement = connection.createStatement();
//			int result = statement.executeUpdate("insert into account values (1,123231231,'muthie' , 'rhioda' , 100000)");
//			System.out.println(result + " row has been inserted..");			
			
//			int result = statement.executeUpdate("update account set bal=100000000 where id =1");
//			System.out.println(result + " row has been updated..");
			
			
//			int result = statement.executeUpdate("dalete from account where id =1");
//			System.out.println(result + " row has been updated..");
			
//			Data generation
			for ( int i =0 ; i<100 ; i++) {
				int sum = statement.executeUpdate("insert into account values ({0},123231231,'muthie' , 'rhioda' , 100000)" ,i);
				System.out.println(sum + " row has been inserted..");
			}
	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
