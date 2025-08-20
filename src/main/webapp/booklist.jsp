<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="package1.Book" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }
        h2 {
            text-align: center;
            margin-top: 30px;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #0083b0;
            color: white;
        }
        form{
        display:inline;
        }
    </style>
</head>
<body>

    <h2>Books Table</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Edition</th>
            <th>Price</th>
            <th>Operation</th>
        </tr>

        <%
        List<Book> books = (List<Book>) request.getAttribute("booklist");
        if (books != null) {
            for (Book b : books) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getName() %></td>
            <td><%= b.getEdition() %></td>
            <td><%= b.getPrice() %></td>
            <td>
            <form action="delete" method="post">
            <input type="hidden" name="id" value="<%=b.getId() %>">
            <button class="btn btn-primary btn-sm">Delete</button>
            
            </form>
       
            <form action="update.jsp" method="post">
            <input type="hidden" name="id" value="<%=b.getId() %>">
            <button type="submit" class="btn btn-warning">Update</button>
            </form>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <tr><td>No books found.</td></tr>
        <% } %>
    </table>

</body>
</html>
