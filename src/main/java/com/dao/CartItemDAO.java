package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.CartItem;

public class CartItemDAO {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    private static final String SELECT_CART_ITEMS_BY_USERID = "SELECT * FROM cart_items WHERE userID = ?";
    private static final String SELECT_CART_ITEM_BY_BOOKISBN = "SELECT * FROM cart_items WHERE bookISBN = ?";
    private static final String INSERT_CART_ITEM = "INSERT INTO cart_items (userID, bookISBN, quantity) VALUES (?, ?, ?)";
//    private static final String DELETE_CART_ITEM_BY_BOOKISBN = "DELETE FROM cart_items WHERE bookISBN = ?";
    private static final String UPDATE_CART_ITEM = "UPDATE cart_items SET quantity = ? WHERE userID = ? AND bookISBN = ?";
//	private static final String DELETE_CART_ITEM_BY_USERID_AND_BOOKISBN = null;
    private static final String DELETE_CART_ITEM_BY_USERID_AND_BOOKISBN = "DELETE FROM cart_items WHERE userID = ? AND bookISBN = ?";

    
    public List<CartItem> getCartItemsByUserID(String userID) {
        List<CartItem> cartItems = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ITEMS_BY_USERID)) {

            preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String bookISBN = resultSet.getString("bookISBN");
                    int quantity = resultSet.getInt("quantity");
                    cartItems.add(new CartItem(bookISBN, quantity));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartItems;
    }

    public CartItem getCartItemByBookISBN(String bookISBN) {
        CartItem cartItem = null;

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ITEM_BY_BOOKISBN)) {

            preparedStatement.setString(1, bookISBN);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int quantity = resultSet.getInt("quantity");
                    cartItem = new CartItem(bookISBN, quantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartItem;
    }

    public boolean addCartItem(CartItem cartItem) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_ITEM)) {

            preparedStatement.setString(1, cartItem.getBookISBN());
            preparedStatement.setInt(2, cartItem.getQuantity());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCartItem(CartItem cartItem, String userID) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ITEM)) {

            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setString(2, userID);
            preparedStatement.setString(3, cartItem.getBookISBN());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCartItem(String userID, String bookISBN) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_ITEM_BY_USERID_AND_BOOKISBN)) {

            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, bookISBN);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
