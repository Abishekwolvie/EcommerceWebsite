<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce</title>
<link rel="stylesheet" href="productstyle.css">
</head>
<body>
<jsp:useBean id="ad" class="dbcode.Adminlogin"></jsp:useBean>
<%@ page import="dbcode.ProductList,java.util.*" %>
    <div class="main">
        <nav id="navbar">
            <span>E COMMERCE</span>
            <div id="anchorlinks">
                <a href="home.html">Home</a>
                <a href="">Order History</a>
            </div>
            <div id="icons">
                <a href="login.html"><img src="user.png" alt=""></a>
                <img src="cart.png" alt="">
            </div>

        </nav>
        <div id="viewproducts">
        	<table rules="all" >
        		<tr>
        			<th class="colhead">Model Name</th>
		        	<th class="colhead">Graphics Card</th>
		        	<th class="colhead">Processor</th>
		        	<th class="colhead">Ram</th>
		        	<th class="colhead">Price</th>
        		</tr>
        			<%
        				ArrayList<ProductList> pl=ad.viewproducts();
        				Iterator<ProductList> it=pl.iterator();
        				while(it.hasNext())
        				{
        					ProductList p=it.next();
        			%>
        			<tr>
        				<th><%=p.getModelname()%></th>
        				<th><%=p.getGraphicscard() %></th>
        				<th><%=p.getProcessor() %></th>
        				<th><%=p.getRam() %></th>
        				<th><%=p.getPrice() %></th>
        			</tr>
        			<%
        				}
        			%>
	        </table>
        </div>

        <footer id="reg"><span>copy Copyright 2020</span></footer>
    </div>

</body>
</html>