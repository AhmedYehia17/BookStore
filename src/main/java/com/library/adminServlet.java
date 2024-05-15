package com.library;


import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;


public class adminServlet extends HttpServlet{
	  private static final long serialVersionUID = 1L;

	    // JDBC URL, username, and password of MySQL server
	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
	    private static final String JDBC_USER = "username";
	    private static final String JDBC_PASSWORD = "password";

	    // SQL query to check if the user is an admin
	    private static final String CHECK_ADMIN_QUERY = "SELECT * FROM admins WHERE username = ? AND password = ?";

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get username and password from request parameters
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Try-with-resources to automatically close resources like Connection and PreparedStatement
	        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_ADMIN_QUERY)) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            
	            // Execute the query
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    // If the user is found in the admins table, redirect to admin panel
	                    response.sendRedirect("admin_panel.jsp");
	                } else {
	                    // If the user is not found, redirect to login page with an error message
	                    response.sendRedirect("admin_login.jsp?error=1");
	                }
	            }
	        } catch (SQLException e) {
	            // Handle any errors that may occur during processing
	            e.printStackTrace();
	            // Optionally, you can forward the request to an error page
	            // request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    }
}
