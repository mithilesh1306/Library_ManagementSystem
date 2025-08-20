package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/final")
public class Orders extends HttpServlet {

    private static final String query = "SELECT * FROM Book";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try {
            // Load the JDBC driver first
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch4", "root", "password");
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                PrintWriter pw = response.getWriter();
            ) {
                // HTML Start
                pw.println("<!DOCTYPE html>");
                pw.println("<html><head>");
                pw.println("<meta charset='UTF-8'>");
                pw.println("<title>Order List</title>");
                pw.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css' rel='stylesheet'>");
                pw.println("</head><body class='bg-light'>");

                pw.println("<div class='container mt-5'>");
                pw.println("<h2 class='text-center mb-4'>Book Orders</h2>");
                pw.println("<table class='table table-bordered table-striped'>");
                pw.println("<thead class='table-primary'>");
                pw.println("<tr><th>Book ID</th><th>Name</th><th>Edition</th><th>Price</th></tr>");
                pw.println("</thead><tbody>");

                while (rs.next()) {
                    pw.println("<tr>");
                    pw.println("<td>" + rs.getInt(1) + "</td>");
                    pw.println("<td>" + rs.getString(2) + "</td>");
                    pw.println("<td>" + rs.getInt(3) + "</td>");
                    pw.println("<td>" + rs.getInt(4) + "</td>");
                    pw.println("</tr>");
                }

                pw.println("</tbody></table>");
                pw.println("<div class='text-center mt-3'>");
                pw.println("<a href='Front.html' class='btn btn-success'>Back to Home</a>");
                pw.println("</div>");
                pw.println("</div>"); // container
                pw.println("</body></html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p style='color:red;'>Something went wrong: " + e.getMessage() + "</p>");
        }
    }
}
