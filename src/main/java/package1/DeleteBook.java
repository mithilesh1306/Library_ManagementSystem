package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteBook extends HttpServlet {
	private static final String query= "delete from Book where bookid=?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/batch4", "root", "password");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			int afdelete=ps.executeUpdate();
			{
				if(afdelete>=1)
					System.out.println("Deleted successfully");
				else
					System.out.println("Not deleted");
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			response.sendRedirect("booklist");
		}
}