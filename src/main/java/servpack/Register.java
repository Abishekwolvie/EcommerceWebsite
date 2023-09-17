package servpack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import dbcode.*;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter(); 
		String regemail=request.getParameter("uemail");
		String regpass=request.getParameter("rupass");
		long regmobile=Long.parseLong(request.getParameter("rusermobno"));
		String ar[]=regemail.split("@");
		String rusername=ar[0];
		
		try {
			
			Dbcon con=new Dbcon();
			int res=con.register(regemail, regpass, regmobile, rusername);
			if(res>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				pw.print("<h1>Registerd Successfully</h1>");
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				pw.print("<h1>Registration failed</h1>");
				rd.include(request, response);
				
			}
				
		}catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			pw.print("<h1>Registration failed</h1>");
			rd.include(request, response);
		}
		
		
	}

}
