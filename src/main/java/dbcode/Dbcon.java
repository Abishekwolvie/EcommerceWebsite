package dbcode;

import java.sql.*;

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
	

}
