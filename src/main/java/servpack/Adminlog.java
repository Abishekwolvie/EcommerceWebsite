package servpack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dbcode.Adminlogin;

/**
 * Servlet implementation class Adminlog
 */
public class Adminlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		java.io.PrintWriter pw=response.getWriter();
		String ademail=request.getParameter("adminemail");
		String adpass=request.getParameter("adminpass");
		try {
			
			Adminlogin ad=new Adminlogin();
			if(ad.validate(ademail, adpass))
			{
				RequestDispatcher rd=request.getRequestDispatcher("adminpage.html");
				pw.print("<h1>Login Success</h1>");
				rd.forward(request, response);
				
			}else
			{
				RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
				pw.print("<h1>Invalid Credentials</h1>");
				rd.include(request, response);
				
			}
			
			
		}catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminlogin.html");
			pw.print("<h1>Sorry Login Failed</h1>");
			rd.include(request, response);
			
		}
		
		
	}

}
