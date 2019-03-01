package com.rhiodamuthie.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private Connection connection;
	private Connection conn;
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		

		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println( firstname + lastname + email + password);
		try {
			
			String url = "jdbc:mysql://localhost:3306/java_jdbc_basics";
			String user = "root";
			String pass = "";

			connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
//			statement.
//			Statement statement = conn.createStatement();
			System.out.println(statement);
			int result = statement.executeUpdate("insert into user values ('" + firstname + "','" + lastname + "','"
					+ email + "','" + password + "')");

			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("<h1>User Created</h1>");

			} else {
				out.print("<h1>ERROR while creating new User </h1>");
			}

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
