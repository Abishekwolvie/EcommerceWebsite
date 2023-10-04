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
<jsp:useBean id="ad" class="dbcode.Dbcon"></jsp:useBean>
<%@ page import="dbcode.ProductList,java.util.*" %>
    <div class="main">
        <nav id="navbar">
            <span>E COMMERCE</span>
            <div id="anchorlinks">
                <a href="home.html">Home</a>
            
            </div>
            <div id="icons">
                <a href="login.html"><img src="user.png" alt=""></a>
                <a href="ShoppingCart.jsp"><img src="cart.png" alt=""></a>
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
		        	<th class="colhead">Add to Cart</th>
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
        				<th> <a href="Cart?prid=<%=p.getPid() %>" ><button style="height:35px; background-color:green; color:white; border-radius:10px">Add to cart</button>  </a>  </th>  <!-- --send the product id to 
        																												Cart servlet to add the products to cart-->
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