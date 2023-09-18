package dbcode;

import java.sql.*;

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

}
