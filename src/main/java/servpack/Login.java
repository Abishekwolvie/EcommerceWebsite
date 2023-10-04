package servpack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import dbcode.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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

		String useremail=request.getParameter("useremail");
		String password=request.getParameter("upass");
		try {
			Dbcon con=new Dbcon();
			if(con.validate(useremail, password))
			{
				RequestDispatcher rd=request.getRequestDispatcher("home.html");
				HttpSession s=request.getSession();
				s.setAttribute("Username", useremail);   // save the user email in the session for session tracking
				rd.forward(request, response);		
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				pw.print("<h1>Invalid Credentials</h1>");
				rd.include(request, response);
			}
			
		}
		catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			pw.print("<h1>Login falied please try again</h1>");
			rd.include(request, response);
		}
		
		
		
	}

}
