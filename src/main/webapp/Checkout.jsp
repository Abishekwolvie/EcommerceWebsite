<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	
	table{
		width:800px;
		height:300px;
		border: 3px solid black;
	}
	table th{
	
		border: 2px solid black;
	
	}


</style>
</head>
<body>
<jsp:useBean id="dbs" class="dbcode.Dbcon"></jsp:useBean>
<%@ page import="dbcode.Addtocart,java.util.*" %>
<%@ page errorPage="Error.jsp" %>
<%
	String user=(String)session.getAttribute("Username");
	long totalamount=dbs.calculatebill(user);
	
	ArrayList<Addtocart> al=dbs.getproductlistfromcart(user);
	Iterator<Addtocart> itr=al.iterator();
%>
<table >
	<tr>
		<th>Model Name</th>
		<th >Graphics Card</th>
		<th>Processor</th>
		<th >Ram</th>
		<th >Price</th>
	</tr>
	<%
		while(itr.hasNext())
		{
			Addtocart adt=itr.next();
	%>
		<tr>
			<th><%=adt.getCrtmodelname() %></th>
			<th><%=adt.getCrtgraphicscard() %> </th>
			<th><%=adt.getCrtProcessor() %></th>
			<th><%=adt.getCrtram() %></th>
			<th><%=adt.getCrtprice() %> </th>
		</tr>
	<%
		}
	%>
</table>
<h1>Total Amount:Rs <%=totalamount %></h1>
<a href="home.html">  <button style="height:35px; background-color:green; color:white; border-radius:10px">Click here to go to home page</button>      </a>

</body>
</html>