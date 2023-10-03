package dbcode;

import java.sql.*;
import java.util.ArrayList;

public class Dbcon {
	
	public static Connection con;
	
	public Dbcon() throws ClassNotFoundException, SQLException //Connection with db
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laptopstore","root","");
	}
	
	public boolean validate(String email,String userpass) throws SQLException   //method to check user details during login
	{
		boolean b=false;
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select *from userinfo");
		while(rs.next())
		{
			if(email.equals(rs.getString("email")) && userpass.equals(rs.getString("userpass")))
			{
				b=true;
				return b;
			}
		}
		
		
		return b;
	}
	
	public int register(String email, String password,long mobilenumber,String username) throws SQLException //create account
	{
		int res=0;
		PreparedStatement ps=con.prepareStatement("insert into userinfo values(?,?,?,?)");
		ps.setString(1, email);
		ps.setString(2, password);
		ps.setLong(3, mobilenumber);
		ps.setString(4, username);
		res=ps.executeUpdate();		
		return res;
	}
	
	public ArrayList<ProductList> viewproducts() throws SQLException
	{
		ArrayList<ProductList> prl=new ArrayList<ProductList>();
		Statement s= con.createStatement();
		ResultSet rs=s.executeQuery("select * from productspec");
		while(rs.next())
		{
			ProductList pl=new ProductList(rs.getString("pmodelname"),rs.getString("Graphicscard"),
					rs.getString("processor"),rs.getString("ram"),rs.getLong("productprice"),rs.getInt("pid"));
			prl.add(pl);
			
		}
		return prl;
	}
	
	public ArrayList<ProductList> viewproductsbyid(int pid) throws SQLException
	{
		ArrayList<ProductList> pr2=new ArrayList<ProductList>();
		PreparedStatement ps=con.prepareStatement("select * from productspec where pid=?");
		ps.setInt(1, pid);
		ResultSet rs2=ps.executeQuery();
		while(rs2.next())
		{
			ProductList p2=new ProductList(rs2.getString("pmodelname"),rs2.getString("Graphicscard"),
					rs2.getString("processor"),rs2.getString("ram"),rs2.getLong("productprice"),rs2.getInt("pid"));
			pr2.add(p2);
			
		}
		return pr2;

	}
	
	public int addtoshoppingcart( String useremail, int crtpid, String crtmodelname, 
			String crtgraphicscard, String crtProcessor, String crtram,long crtprice) throws SQLException// to add the products to the shopping cart
	{
		int res=0;
		PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?,?,?,?,?)");
		ps.setString(1, useremail);
		ps.setInt(2, crtpid);
		ps.setString(3, crtmodelname);
		ps.setString(4, crtgraphicscard);
		ps.setString(5, crtProcessor);
		ps.setString(6, crtram);
		ps.setLong(7, crtprice);
		res=ps.executeUpdate();
		return res;
	}
	
	public ArrayList<Addtocart> getproductlistfromcart(String useremailid) throws SQLException //method to get products from the cart based on the useremail
	{
		ArrayList<Addtocart> cl=new ArrayList<Addtocart>();
		
		PreparedStatement ps=con.prepareStatement("select *from cart where useremail=?");
		ps.setString(1, useremailid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Addtocart act=new Addtocart(rs.getString("useremail"),rs.getInt("productid"),
					rs.getString("productmodelname"),rs.getString("prgraphicscard"),rs.getString("prprocessor"),rs.getString("prram"),rs.getLong("prproductprice"));
			cl.add(act);
		}
		
		return cl;
	}
	

}
