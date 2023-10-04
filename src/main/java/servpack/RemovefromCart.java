package servpack;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dbcode.Dbcon;

/**
 * Servlet implementation class RemovefromCart
 */
public class RemovefromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovefromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		java.io.PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("useremail");
		int productid=Integer.parseInt(request.getParameter("pridrem"));
		try {
			
			Dbcon db=new Dbcon();
			int res1=db.removefromcart(username, productid);
			if(res1>0) {
				RequestDispatcher rd=request.getRequestDispatcher("ShoppingCart.jsp");
				pw.print("<h1>Product removed from cart</h1>");
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("ShoppingCart.jsp");
				pw.print("<h1>Failed to remove from cart</h1>");
				rd.include(request, response);
				
			}
			
		}
		catch(Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("ShoppingCart.jsp");
			pw.print("<h1>Failed to remove from cart Exception</h1>");
			rd.include(request, response);
		}
	}

}
