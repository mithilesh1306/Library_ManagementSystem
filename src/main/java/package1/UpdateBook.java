package package1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class UpdateBook extends HttpServlet {

    private static final String QUERY = "UPDATE Book SET bookname = ?, bookedition = ?, bookprice = ? WHERE bookid = ?";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set encoding and content type
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        // Get parameters
        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String editionParam = request.getParameter("edition");
        String priceParam = request.getParameter("price");

        try {
            // Validate inputs
            if (idParam == null || name == null || editionParam == null || priceParam == null ||
                name.trim().isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid parameters.");
                return;
            }

            int id = Integer.parseInt(idParam);
            int edition = Integer.parseInt(editionParam);
            int price = Integer.parseInt(priceParam);

            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Use try-with-resources to ensure proper closure of DB resources
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch4", "root", "password");
                 PreparedStatement ps = con.prepareStatement(QUERY)) {

                ps.setString(1, name);
                ps.setInt(2, edition);
                ps.setInt(3, price);
                ps.setInt(4, id);

                int updated = ps.executeUpdate();

                if (updated >= 1) {
                    System.out.println("Updated successfully");
                } else {
                    System.out.println("No record found to update");
                }

            }

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid number format: " + e.getMessage());
            return;

        } catch (Exception e) {
            e.printStackTrace(); // Log the error
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error: " + e.getMessage());
            return;
        }

        // Redirect after successful update
        response.sendRedirect("booklist");
    }
}
