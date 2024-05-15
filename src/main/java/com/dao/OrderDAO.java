package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Order;
import com.library.DatabaseConnection;

public class OrderDAO {

    private static final String SELECT_ORDERS_BY_USERID = "SELECT * FROM orders WHERE userID = ?";
    private static final String SELECT_ORDER_BY_ORDERID = "SELECT * FROM orders WHERE orderID = ?";
    private static final String INSERT_ORDER = "INSERT INTO orders (userID, orderDate) VALUES (?, ?)";
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE orderID = ?";
    private static final String UPDATE_ORDER = "UPDATE orders SET userID = ?, orderDate = ? WHERE orderID = ?";
    
    private static final String INSERT_ORDER_DETAIL = "INSERT INTO orderDetails (orderDetailsID, orderID, isbn) VALUES (?, ?, ?)";
    private static final String DELETE_ORDER_DETAIL_BY_ORDERID = "DELETE FROM orderDetails WHERE orderID = ?";

    public List<Order> getOrdersByUserID(String userID) {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USERID)) {

            preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String orderID = resultSet.getString("orderID");
                    // Assuming you have an Order constructor that takes orderID, userID, and orderDate
                    Order order = new Order(orderID, userID, resultSet.getDate("orderDate"));
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // Other methods for getOrderById, addOrder, updateOrder, and deleteOrder are here...
    
    public boolean addOrderDetail(String orderDetailsID, String orderID, String isbn) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_DETAIL)) {

            preparedStatement.setString(1, orderDetailsID);
            preparedStatement.setString(2, orderID);
            preparedStatement.setString(3, isbn);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteOrderDetailsByOrderID(String orderID) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_DETAIL_BY_ORDERID)) {

            preparedStatement.setString(1, orderID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
