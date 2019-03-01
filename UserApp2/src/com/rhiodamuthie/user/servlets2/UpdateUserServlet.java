package com.rhiodamuthie.user.servlets2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		
		String url = "jdbc:mysql://localhost:3306/java_jdbc_basics";
		String user = "root";
		String pass ="";
		
		
		try {
			connection = DriverManager.getConnection(url, user, pass);
			Statement statement = connection.createStatement();
			System.out.println(connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into user values ('"+firstname+"','"+lastname+"','"+email+"','"+password+"')");
			
			out = response.getWriter();
			if (result >0) {
				out.println("<h1>User Created</h1>");
				
			}else {
				out.println("<h1>ERROR while creating new User </h1>");
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
