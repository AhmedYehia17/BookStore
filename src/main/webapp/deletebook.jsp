<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Book</title>
</head>
<body>
    <h1>Delete Book</h1>
    <form action="deletebook" method="post">
        <label for="isbn">ISBN of the Book to Delete:</label>
        <input type="text" id="isbn" name="isbn" required><br><br>
        
        <button type="submit">Delete Book</button>
    </form>
    <a href="admin.jsp">Back to Admin Panel</a>
</body>
</html>
