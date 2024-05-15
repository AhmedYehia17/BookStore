package com.library;
	

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beans.Order;
import com.dao.OrderDAO;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

public class orderhistoryServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    // JDBC URL, username, and password of MySQL server
//	    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
//	    private static final String JDBC_USER = "username";
//	    private static final String JDBC_PASSWORD = "password";
//
//	    // SQL query to fetch order history for a specific user
//	    private static final String SELECT_ORDER_HISTORY = "SELECT * FROM orders WHERE user_id = ?";
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Assuming you have access to the user ID of the logged-in user
	        String userID = "user123"; // Replace this with the actual user ID

	        // Create an instance of OrderDAO
	        OrderDAO orderDAO = new OrderDAO();

	        // Retrieve the list of orders for the user from the database
	        List<Order> orderHistory = orderDAO.getOrdersByUserID(userID);

	        // Set the orderHistory attribute in the request
	        request.setAttribute("orderHistory", orderHistory);

	        // Forward the request to the orderhistory.jsp page
	        request.getRequestDispatcher("orderhistory.jsp").forward(request, response);
	    }
}
