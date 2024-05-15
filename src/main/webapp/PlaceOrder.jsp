<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Place Order</h1>
    <form action="placeorder" method="post">
        <label for="userID">User ID:</label>
        <input type="text" id="userID" name="userID" required><br><br>
        
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" required><br><br>
        
        <input type="submit" value="Place Order">
    </form>
</body>
</html>