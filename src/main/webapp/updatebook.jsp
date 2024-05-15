<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
</head>
<body>
    <h1>Update Book Details</h1>
    <form action="updatebook" method="post">
        <label for="isbn">ISBN of the Book to Update:</label>
        <input type="text" id="isbn" name="isbn" required><br><br>
        
        <!-- Include fields to update -->
        <label for="title">Title:</label>
        <input type="text" id="title" name="title"><br><br>
        
        <label for="author">Author(s):</label>
        <input type="text" id="author" name="author"><br><br>
        
        <label for="publicationDate">Publication Date:</label>
        <input type="date" id="publicationDate" name="publicationDate"><br><br>
        
        <label for="category">Category:</label>
        <input type="text" id="category" name="category"><br><br>
        
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"><br><br>
        
        <button type="submit">Update Book</button>
    </form>
    <a href="admin.jsp">Back to Admin Panel</a>
</body>
</html>
