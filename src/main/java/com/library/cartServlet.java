package com.library;


import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import com.beans.CartItem;
import com.dao.CartItemDAO;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class cartServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");
        if (userID == null) {
            // Redirect to login page or handle unauthorized access
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if (action != null) {
            CartItemDAO cartItemDAO = new CartItemDAO();
            List<CartItem> cartItems = cartItemDAO.getCartItemsByUserID(userID);

            // Set cartItems as an attribute in the request object
            request.setAttribute("cartItems", cartItems);

            // Forward the request to the JSP page for rendering
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
            if (action.equals("add")) {
                String bookISBN = request.getParameter("bookISBN");
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                CartItem cartItem = new CartItem(bookISBN, quantity);
                cartItemDAO.addCartItem(cartItem);
            } else if (action.equals("update")) {
                String bookISBN = request.getParameter("bookISBN");
                int quantity = Integer.parseInt(request.getParameter("quantity"));

                CartItem cartItem = new CartItem(bookISBN, quantity);
                cartItemDAO.updateCartItem(cartItem, userID);
            } else if (action.equals("remove")) {
                String bookISBN = request.getParameter("bookISBN");
                cartItemDAO.deleteCartItem(userID, bookISBN);
            }
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }
}
