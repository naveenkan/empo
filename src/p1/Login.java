package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import p2.Valid;

/**
 * Servlet implementation class Login
 */
@WebServlet("Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		try{
			String i=Valid.check(name, password);
			if(i.equals("10")){
				ResultSet rs=Valid.hr();
				while(rs.next()){
					out.println("<html>");
					out.println("<body>");
					out.println("<table border='2'>");
					out.println("<tr><td>"+rs.getString(1)+"</td></tr>");
					/*out.println(rs.getString(2));
					out.println(rs.getString(3));
					out.println(rs.getString(4));*/
					out.println("<table>");
					out.println("</body>");
					out.println("</html>");
				
				}}
				
				else if(i.equals("20")){
					ResultSet rs=Valid.emp(name, password);
					while(rs.next()){
						out.println("<html>");
						out.println("<body>");
						out.println("<table border='2'>");
						out.println("<tr><td>"+rs.getString(1)+"</td></tr>");
						/*out.println(rs.getString(2));
						out.println(rs.getString(3));
						out.println(rs.getString(4));*/
						out.println("<table>");
						out.println("</body>");
						out.println("</html>");
						}}
				
			else{
				out.println("no data found");
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			
		}
		
		
	}




