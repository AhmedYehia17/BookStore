package com.library;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.beans.Book;

public class BookFactory {
    public static Book createBook(ResultSet resultSet) throws SQLException {
        String isbn = resultSet.getString("isbn");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        double price = resultSet.getDouble("price");
        Date pub_date = resultSet.getDate("publicationDate");
        String category = resultSet.getString("category");

        return new Book(isbn, title, author, pub_date, category, price);
    }
}