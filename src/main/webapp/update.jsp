<%@ page import="java.sql.*, package1.Book" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Book book = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch4", "root", "password");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Book WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            book = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
        }
        rs.close();
        ps.close();
        con.close();
    } catch(Exception e) {
        out.println(e);
    }
%>

<html>
<head>
    <title>Edit Book</title>
</head>
<body>
    <h2>Edit Book</h2>
    <form action="updateBook" method="post">
        <input type="hidden" name="id" value="<%= book.getId() %>">
        Name: <input type="text" name="name" value="<%= book.getName() %>"><br><br>
        Edition: <input type="number" name="edition" value="<%= book.getEdition() %>"><br><br>
        Price: <input type="number" name="price" value="<%= book.getPrice() %>"><br><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>