package com.library;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class logoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Invalidate the session to log out the user
            session.invalidate();
            // Redirect the user to the login page or any other appropriate page after logout
            response.sendRedirect("login.jsp");
        } else {
            // If there's no session, redirect to the login page anyway
            response.sendRedirect("login.jsp");
        }
    }
}
