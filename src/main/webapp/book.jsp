<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beans.Book" %>
<%@ page import="com.library.bookServlet" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Details</title>
</head>
<body>
    <h1>Book Details</h1>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author(s)</th>
            <th>Publication Date</th>
            <th>Category</th>
            <th>Price</th>
        </tr>
        <% 
            List<Book> bookList = (List<Book>) request.getAttribute("books");
            if (bookList != null) {
                for (Book book : bookList) {
        %>
                    <tr>
                        <td><%= book.getIsbn() %></td>
                        <td><%= book.getTitle() %></td>
                        <td><%= book.getAuthor() %></td>
                        <td><%= book.getPublicationDate() %></td>
                        <td><%= book.getCategory() %></td>
                        <td><%= book.getPrice() %></td>
                    </tr>
        <% 
                }
            }
        %>
    </table>
    <a href="index.jsp">Back to Home</a>
    <a href="index.jsp">place an order</a>
</body>
</html>
