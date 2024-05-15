package com.library;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.UserDAO;

public class loginServlet extends HttpServlet {

//	 private static final long serialVersionUID = 1L;
	    
	 private static final long serialVersionUID = 1L;
	    private UserDAO userDAO;

	    @Override
	    public void init() throws ServletException {
	        super.init();
	        // Initialize the UserDAO instance
	        userDAO = new UserDAO();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        // Call the validateUser method in UserDAO to check if the user is valid
	        boolean isValidUser = userDAO.validateUser(username, password);

	        if (isValidUser) {
	            // If the user is valid, you can redirect to a success page or do any other actions
	            response.sendRedirect("success.jsp");
	        } else {
	            // If the user is not valid, you can redirect to an error page or display an error message
	            response.sendRedirect("error.jsp");
	        }
	    }
	
}
