package com.library;

//import java.io.PrintWriter;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.beans.User;
import com.dao.UserDAO;

public class registerServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    private UserDAO userDAO; // Initialize the UserDAO instance

	    @Override
	    public void init() throws ServletException {
	        super.init();
	        // Initialize the UserDAO instance
	        userDAO = new UserDAO();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String confirmPassword = request.getParameter("confirmPassword");
	        String email = request.getParameter("email");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");

	        // Validate the registration data
	        boolean isValidRegistration = validateRegistration(username, password, confirmPassword);

	        if (isValidRegistration) {
	            // If the registration data is valid, create a User object and add it to the database
	            User user = new User(username, password, email, firstName, lastName);
	            boolean isUserAdded = userDAO.addUser(user);

	            if (isUserAdded) {
	                // If the user is successfully added to the database, redirect to a success page
	                response.sendRedirect("registrationSuccess.jsp");
	            } else {
	                // If there was an error adding the user to the database, redirect to an error page
	                response.sendRedirect("registrationError.jsp");
	            }
	        } else {
	            // If the registration data is not valid, redirect to an error page
	            response.sendRedirect("registrationError.jsp");
	        }
	    }

	    private boolean validateRegistration(String username, String password, String confirmPassword) {
	        // This is just a placeholder method, you should replace it with your actual validation logic
	        // For example, you might check if the username is not already taken, if the passwords match, etc.
	        // Here we check if the username, password, and confirmPassword are not null or empty,
	        // and if the password matches the confirmPassword
	        return username != null && !username.isEmpty() &&
	               password != null && !password.isEmpty() &&
	               confirmPassword != null && !confirmPassword.isEmpty() &&
	               password.equals(confirmPassword);
	    }
}
