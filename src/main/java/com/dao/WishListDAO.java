package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.WishlistItem;
import com.library.DatabaseConnection;

public class WishListDAO {

    private static final String SELECT_WISHLIST_ITEMS_BY_USERID = "SELECT * FROM wishlist_items WHERE userID = ?";
    private static final String SELECT_WISHLIST_ITEM_BY_BOOKISBN = "SELECT * FROM wishlist_items WHERE bookISBN = ?";
    private static final String INSERT_WISHLIST_ITEM = "INSERT INTO wishlist_items (userID, bookISBN) VALUES (?, ?)";
    private static final String DELETE_WISHLIST_ITEM_BY_BOOKISBN = "DELETE FROM wishlist_items WHERE bookISBN = ?";

    public List<WishlistItem> getWishlistItemsByUserID(String userID) {
        List<WishlistItem> wishlistItems = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WISHLIST_ITEMS_BY_USERID)) {

            preparedStatement.setString(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String bookISBN = resultSet.getString("bookISBN");
                    wishlistItems.add(new WishlistItem(bookISBN));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlistItems;
    }

    public WishlistItem getWishlistItemByBookISBN(String bookISBN) {
        WishlistItem wishlistItem = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_WISHLIST_ITEM_BY_BOOKISBN)) {

            preparedStatement.setString(1, bookISBN);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    wishlistItem = new WishlistItem(bookISBN);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlistItem;
    }

    public boolean addWishlistItem(WishlistItem wishlistItem) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WISHLIST_ITEM)) {

            preparedStatement.setString(1, wishlistItem.getBookISBN());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteWishlistItem(String bookISBN) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_WISHLIST_ITEM_BY_BOOKISBN)) {

            preparedStatement.setString(1, bookISBN);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
