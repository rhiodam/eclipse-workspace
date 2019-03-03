package com.rhiodamuthie.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class CreateUserServlet
 */
//@WebServlet("/ReadUserServlet")
public class ReadUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private Connection connection;
	private Connection conn;
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} 

		try {

			String url = "jdbc:mysql://localhost:3306/java_jdbc_basics";
			String user = "root";
			String pass = "";

			connection = DriverManager.getConnection(url, user, pass);

			System.out.println("MySQL connection is :" + connection);
			
			
//			WAY 2
			
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser(user);
			dataSource.setPassword(pass);
			dataSource.setServerName(url);
			
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
			
//			rs.close();
//			stmt.close();
//			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		

		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			
			PrintWriter out = response.getWriter();
			
			out.println("<h1>USER TABLE LIST </h1>");
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.print("Firstname");
			out.print("</th>");
			out.print("<th>");
			out.print("Lastname");
			out.print("</th>");
			out.print("<th>");
			out.print("Email");
			out.print("</th>");
			out.print("</tr>");
			
			while(resultSet.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(resultSet.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			
			out.print("</table>");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
