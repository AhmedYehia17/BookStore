package com.library;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import com.library.BookDAO;

import com.dao.BookDAO;

public class DeleteBookServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");

        // Call the DAO method to delete the book
        BookDAO bookDAO = new BookDAO();
        boolean success = bookDAO.deleteBook(isbn);

        if (success) {
            // Book deleted successfully
            response.sendRedirect("success.jsp"); // Redirect to a success page
        } else {
            // Book deletion failed
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}
