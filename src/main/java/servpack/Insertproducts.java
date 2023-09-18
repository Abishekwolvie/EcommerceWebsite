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
 * Servlet implementation class Insertproducts
 */
public class Insertproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertproducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		java.io.PrintWriter pw=response.getWriter();
		
		String prmodelname=request.getParameter("modelname");
		String graphicscard=request.getParameter("prgraphics");
		String processor=request.getParameter("processor");
		String ram=request.getParameter("ram");
		long productprice=Long.parseLong(request.getParameter("price"));
		
		try {
			
			Adminlogin ad=new Adminlogin();
			int res=ad.addproducts(prmodelname, graphicscard, processor, ram, productprice);
			if(res>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("adminpage.html");
				pw.print("<h1>Products added Successfully</h1>");
				rd.include(request, response);
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("insertproducts.html");
				pw.print("<h1>Failed to add products</h1>");
				rd.include(request, response);
			}
			
			
		}
		catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("insertproducts.html");
			pw.print("<h1>Failed to add products</h1>");
			rd.include(request, response);
		}
	}

}
