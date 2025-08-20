package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class ServletBooks extends HttpServlet {
    
    private static final String QUERY = "INSERT INTO Book(bookname, bookedition, bookprice) VALUES (?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String editionStr = request.getParameter("edition");
        String priceStr = request.getParameter("price");

        try {
            // Input validation
            if (name == null || editionStr == null || priceStr == null || name.trim().isEmpty()) {
                pw.println("<h3>Missing required fields!</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
                rd.include(request, response);
                return;
            }

            int edition = Integer.parseInt(editionStr);
            int price = Integer.parseInt(priceStr);

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Try-with-resources for DB operations
            try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/batch4", "root", "password");
                 PreparedStatement ps = con.prepareStatement(QUERY)) {
                
                ps.setString(1, name);
                ps.setInt(2, edition);
                ps.setInt(3, price);

                int result = ps.executeUpdate();

                // Forward to JSP and include a message
                request.setAttribute("message", (result == 1) ? 
                        "Book inserted successfully!" : 
                        "Failed to insert book.");
                RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
                rd.forward(request, response);
            }

        } catch (NumberFormatException e) {
            pw.println("<h3>Invalid number format for edition or price.</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace(pw);
            pw.println("<h3>Internal error: " + e.getMessage() + "</h3>");
            RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
            rd.include(request, response);
        }
    }
}
