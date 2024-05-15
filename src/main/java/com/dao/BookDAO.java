package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.library.DatabaseConnection;

public class BookDAO {

    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String SELECT_BOOK_BY_ISBN = "SELECT * FROM books WHERE isbn = ?";
    private static final String INSERT_BOOK = "INSERT INTO books (isbn, title, author, publicationDate, category, price) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_BOOK_BY_ISBN = "DELETE FROM books WHERE isbn = ?";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, author = ?, publicationDate = ?, category = ?, price = ? WHERE isbn = ?";

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String isbn = resultSet.getString("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                java.util.Date publicationDate = resultSet.getDate("publicationDate");
                String category = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                books.add(new Book(isbn, title, author, publicationDate, category, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book getBookByISBN(String isbn) {
        Book book = null;

        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ISBN)) {

            preparedStatement.setString(1, isbn);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    java.util.Date publicationDate = resultSet.getDate("publicationDate");
                    String category = resultSet.getString("category");
                    double price = resultSet.getDouble("price");
                    book = new Book(isbn, title, author, publicationDate, category, price);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    public boolean addBook(Book book) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)) {

            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDate(4, new java.sql.Date(book.getPublicationDate().getTime()));
            preparedStatement.setString(5, book.getCategory());
            preparedStatement.setDouble(6, book.getPrice());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(Book book) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDate(3, new java.sql.Date(book.getPublicationDate().getTime()));
            preparedStatement.setString(4, book.getCategory());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setString(6, book.getIsbn());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(String isbn) {
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_BY_ISBN)) {

            preparedStatement.setString(1, isbn);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
