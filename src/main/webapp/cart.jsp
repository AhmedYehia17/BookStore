<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beans.CartItem" %>
<%@ page import="java.util.List" %>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
</head>
<body>
    <h1>Shopping Cart</h1>
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Quantity</th>
        </tr>
        <% 
            List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
            if (cartItems != null) {
                for (int i = 0; i < cartItems.size(); i++) { 
                    CartItem item = cartItems.get(i);
        %>
            <tr>
                <td><%= item.getBookISBN() %></td>
                <td><%= item.getQuantity() %></td>
            </tr>
        <% 
                } // End of for loop
            } // End of if condition
        %>
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>