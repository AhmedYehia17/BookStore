<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beans.WishlistItem" %>
<%@ page import="com.beans.Book" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Wishlist</title>
</head>
<body>
    <h1>Wishlist</h1>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author(s)</th>
            <th>Category</th>
            <th>Price</th>
            <!-- Add more columns if needed -->
        </tr>
      <% 
		List<Book> wishlistItems = (List<Book>) request.getAttribute("wishlist");
		int itemCount = wishlistItems.size();
		
		for (int i = 0; i < itemCount; i++) {
		    Book book = wishlistItems.get(i);
		%>
		    <tr>
		        <td><%= book.getIsbn() %></td>
		        <!-- Add other columns as needed -->
		    </tr>
		<% } %>

        
      
        
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
