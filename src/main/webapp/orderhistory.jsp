<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.beans.Order" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
</head>
<body>
    <h1>Order History</h1>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>User ID</th>
            <th>Order Date</th>
            <!-- Add more columns if needed -->
        </tr>
      <% for (Order order : (List<Order>) request.getAttribute("orderHistory")) { %>
    <tr>
        <td><%= order.getOrderID() %></td>
        <td><%= order.getOrderDate() %></td>
        <td><%= order.getUserID() %></td>
        <!-- Add more columns if needed -->
    </tr>
<% } %>
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
