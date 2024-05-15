package com.library;
//import java.sql.Connection;
//import java.sql.SQLException;

import com.beans.Book;
import com.beans.User;
import com.dao.BookDAO;
import com.dao.OrderDAO;
import com.dao.UserDAO;

public class Main {
    public static void main(String[] args) {
//    	 UserDAO userDAO = new UserDAO();
//
//         // Assuming you have a user with userID = 1 that you want to update
//         User existingUser = userDAO.getUserByUserID("1");
//
//         if (existingUser != null) {
//             // Update the user's information
//             existingUser.setUserName("AhmedYehia17");
//             existingUser.setPassword("123");
//             existingUser.setEmail("shendy@gmail.com");
//             existingUser.setFirstName("Ahmed");
//             existingUser.setLastName("Yehia");
//            
//
//             // Call the updateUser method
//             boolean updateUserSuccess = userDAO.updateUser(existingUser);
//
//             if (updateUserSuccess) {
//                 System.out.println("User updated successfully!");
//             } else {
//                 System.out.println("Failed to update user.");
//             }
//         } else {
//             System.out.println("User not found.");
//         }

    	
//    	
//    	 UserDAO userDAO = new UserDAO();
//
//         // Assuming you have a user with userID = 1 that you want to delete
//         String userIDToDelete = "1";
//
//         // Call the deleteUser method
//         boolean deleteUserSuccess = userDAO.deleteUser(userIDToDelete);
//
//         if (deleteUserSuccess) {
//             System.out.println("User with ID " + userIDToDelete + " deleted successfully!");
//         } else {
//             System.out.println("Failed to delete user with ID " + userIDToDelete + ".");
//         }
    	
//    	
//    	  UserDAO userDAO = new UserDAO();
//
//          // Create a new User object
//          User newUser = new User();
//          newUser.setUserName("Ahmed");
//          newUser.setPassword("password");
//          newUser.setEmail("shendy@example.com");
//          newUser.setFirstName("Ahmed");
//          newUser.setLastName("Yehia");
//
//          // Attempt to add the user
//          boolean addUserSuccess = userDAO.addUser(newUser);
//          System.out.println("User added: " + addUserSuccess);
//
//          // Verify the user was added
//          User user = userDAO.getUserByUsername("newUser");
//          if (user != null) {
//              System.out.println("User found: " + user.getUserName());
//          } else {
//              System.out.println("User not found.");
//          }
    	
//    	 BookDAO bookDAO = new BookDAO();
//
//         // Create a new Book object with book details
//         Book newBook = new Book("9781234567890", "Sample Book", "Sample Author", new java.util.Date(), "Sample Category", 19.9);
//
//         // Call the addBook method
//         boolean addBookSuccess = bookDAO.addBook(newBook);
//
//         if (addBookSuccess) {
//             System.out.println("Book added successfully!");
//         } else {
//             System.out.println("Failed to add book.");
//         }
//        
    	
//    	 BookDAO bookDAO = new BookDAO();
//
//         // Retrieve a book from the database that you want to update
//         Book bookToUpdate = bookDAO.getBookByISBN("9781234567890");
//
//         if (bookToUpdate != null) {
//             // Modify the attributes of the retrieved book
//             bookToUpdate.setTitle("Updated Title");
//             bookToUpdate.setAuthor("Updated Author");
//             // Modify other attributes as needed...
//
//             // Call the updateBook method
//             boolean updateBookSuccess = bookDAO.updateBook(bookToUpdate);
//
//             if (updateBookSuccess) {
//                 System.out.println("Book updated successfully!");
//             } else {
//                 System.out.println("Failed to update book.");
//             }
//         } else {
//             System.out.println("Book not found.");
//         }
    	
//    	 BookDAO bookDAO = new BookDAO();
//
//         // Choose an ISBN of the book you want to delete
//         String isbnToDelete = "9781234567890";
//
//         // Call the deleteBook method
//         boolean deleteBookSuccess = bookDAO.deleteBook(isbnToDelete);
//
//         if (deleteBookSuccess) {
//             System.out.println("Book with ISBN " + isbnToDelete + " deleted successfully!");
//         } else {
//             System.out.println("Failed to delete book with ISBN " + isbnToDelete + ".");
//         }
    	
    	
    	 OrderDAO orderDetailsDAO = new OrderDAO();
         
         // Create test data
         String orderDetailsID = "123";
         String orderID = "456";
         String isbn = "789";
         
         // Call addOrderDetail method
         boolean result = orderDetailsDAO.addOrderDetail(orderDetailsID, orderID, isbn);
         
         // Check if the result is true
         if (result) {
             System.out.println("Order detail added successfully.");
         } else {
             System.out.println("Failed to add order detail.");
         }
    }
}
