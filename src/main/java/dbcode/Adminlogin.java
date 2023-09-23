package dbcode;

import java.sql.*;
import java.util.ArrayList;

public class Adminlogin extends Dbcon{
	
	public Adminlogin() throws ClassNotFoundException, SQLException
	{
		super();
	}
	
	public int  addproducts(String prmodelname,String prgraphics,String processor,String ram,long productprice)throws SQLException
	{
		int res=0;
		PreparedStatement ps=con.prepareStatement("insert into productspec(pmodelname,Graphicscard,processor,ram,productprice) values(?,?,?,?,?)");
		ps.setString(1, prmodelname);
		ps.setString(2, prgraphics);
		ps.setString(3, processor);
		ps.setString(4, ram);
		ps.setLong(5, productprice);
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
					rs.getString("processor"),rs.getString("ram"),rs.getLong("productprice"));
			prl.add(pl);
			
		}
		return prl;
	}

}
