<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
</head>
<body>
    <h1>Add New Book</h1>
    <form action="addbook" method="post">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" required><br><br>
        
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="author">Author(s):</label>
        <input type="text" id="author" name="author" required><br><br>
        
        <label for="publicationDate">Publication Date:</label>
        <input type="date" id="publicationDate" name="publicationDate" required><br><br>
        
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" required><br><br>
        
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" required><br><br>
        
        <button type="submit">Add Book</button>
    </form>
    <a href="admin.jsp">Back to Admin Panel</a>
</body>
</html>
