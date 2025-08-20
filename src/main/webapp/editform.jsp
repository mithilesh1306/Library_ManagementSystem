<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
    <h2>Edit Book</h2>
    <form action="Update" method="post">
        <input type="hidden" name="id" value="${id}"/>

        <label>Book Name:</label>
        <input type="text" name="name" value="${name}" required/><br><br>

        <label>Edition:</label>
        <input type="number" name="edition" value="${edition}" required/><br><br>

        <label>Price:</label>
        <input type="number" name="price" value="${price}" required/><br><br>

        <input type="submit" value="Update Book"/>
    </form>
</body>
</html>
