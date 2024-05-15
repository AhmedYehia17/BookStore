package com.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String JDBC_USER = "username";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve book details from the form
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publicationDate = request.getParameter("publicationDate");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));

        // Insert the book into the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "INSERT INTO books (isbn, title, author, publicationDate, category, price) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, isbn);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, author);
                preparedStatement.setString(4, publicationDate);
                preparedStatement.setString(5, category);
                preparedStatement.setDouble(6, price);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    // Book added successfully
                    response.sendRedirect("admin.jsp");
                } else {
                    // Handle insertion failure
                    response.getWriter().println("Failed to add book.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or query execution errors
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
