package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class Log extends HttpServlet {
	private static final String query= "insert into login(loginid,password) values(?,?)";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		//loading jdbc
		String login=request.getParameter("username");
		String password=request.getParameter("password");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/batch4", "root", "password");
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,login);
			ps.setString(2,password);
			ps.executeUpdate();
			response.sendRedirect("front.jsp");
	}
		catch(Exception e)
		{
			System.out.println(e);
			response.getWriter().println("<h2 style='color:red'> Error:"+e.getMessage()+"</h2>");
		}
		
	}
	}
