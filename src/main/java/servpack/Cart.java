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
import java.util.ArrayList;
import java.util.Iterator;

import dbcode.Dbcon;
import dbcode.*;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter(); 
		HttpSession s=request.getSession(false);
		String usercred=(String)s.getAttribute("Username"); // get the username from the session to addthe name to cart
		int productid=Integer.parseInt(request.getParameter("prid"));// get the product id from jsp page
		ArrayList<ProductList> prl;
		try {
			Dbcon dbcon=new Dbcon();
			prl=dbcon.viewproductsbyid(productid); //method to view products by id
			Iterator<ProductList> it=prl.iterator();
			ProductList p;
			int res=0;
			while(it.hasNext())
			{
				p=it.next();
				res=dbcon.addtoshoppingcart(usercred, p.getPid(), p.getModelname(), p.getGraphicscard(), p.getProcessor(), p.getRam(), p.getPrice()); // method to add product to cart
			}
			if(res>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
				pw.print("<h1>Added to cart</h1>");
				rd.include(request, response);
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
				pw.print("<h1>Failed to add to  cart</h1>");
				rd.include(request, response);
				
			}
			
			
		}catch (Exception e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
			pw.print("<h1>Failed to add to  cart</h1>");
			rd.include(request, response);
		}
		
		
	}

}
