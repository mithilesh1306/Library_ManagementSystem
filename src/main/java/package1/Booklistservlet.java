package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/booklist")

public class Booklistservlet extends HttpServlet {
	private static final String query= "select * from Book";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/batch4", "root", "password");
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			List <Book> book=new ArrayList<>();
			
			while (rs.next()) {
                book.add(new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
			request.setAttribute("booklist",book);
			RequestDispatcher rd=request.getRequestDispatcher("booklist.jsp");
			rd.forward(request,response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}
}
