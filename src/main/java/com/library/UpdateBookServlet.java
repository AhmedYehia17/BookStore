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

public class UpdateBookServlet extends HttpServlet {
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

        // Update the book in the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "UPDATE books SET title = ?, author = ?, publicationDate = ?, category = ?, price = ? WHERE isbn = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, publicationDate);
                preparedStatement.setString(4, category);
                preparedStatement.setDouble(5, price);
                preparedStatement.setString(6, isbn);

                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    // Book updated successfully
                    response.sendRedirect("admin.jsp");
                } else {
                    // Handle update failure
                    response.getWriter().println("Failed to update book.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or query execution errors
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
