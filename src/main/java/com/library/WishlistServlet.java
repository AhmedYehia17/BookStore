package com.library;



import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.WishlistItem;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;


public class WishlistServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String JDBC_USER = "username";
    private static final String JDBC_PASSWORD = "password";

    // SQL query to fetch all items in the wishlist
    private static final String SELECT_ALL_ITEMS = "SELECT * FROM wishlist";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // List to hold fetched items from the database
        List<WishlistItem> items = new ArrayList<>();

        // Try-with-resources to automatically close resources like Connection and PreparedStatement
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEMS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate through the result set and populate the list of wishlist items
            while (resultSet.next()) {
                String isbn = resultSet.getString("bookISBN");
                items.add(new WishlistItem(isbn));
            }
        } catch (SQLException e) {
            // Handle any errors that may occur during processing
            e.printStackTrace();
            // Optionally, you can forward the request to an error page
            // request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        // Set the fetched items as an attribute in the request
        request.setAttribute("wishlistItems", items);

        // Forward the request to the wishlist.jsp page to display the wishlist items
        request.getRequestDispatcher("wishlist.jsp").forward(request, response);
    }
}
