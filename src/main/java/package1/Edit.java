package package1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class Edit extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/batch4", "root", "password");
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Book WHERE bookid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                request.setAttribute("id", rs.getInt("bookid"));
                request.setAttribute("name", rs.getString("bookname"));
                request.setAttribute("edition", rs.getInt("bookedition"));
                request.setAttribute("price", rs.getInt("bookprice"));

                request.getRequestDispatcher("editform.jsp").forward(request, response);
            } else {
                response.getWriter().println("Book not found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace(response.getWriter());
        }
    }
}
