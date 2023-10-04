<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E Commerce</title>
<link rel="stylesheet" href="productstyle.css">
</head>
<body>
<jsp:useBean id="ad" class="dbcode.Dbcon"></jsp:useBean>
<%@ page import="dbcode.Addtocart,java.util.*" %>
    <div class="main">
        <nav id="navbar">
            <span>E COMMERCE</span>
            <div id="anchorlinks">
                <a href="home.html">Home</a>
                <a href="products.jsp">Products</a>
   
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
		        	<th class="colhead">Remove from Cart</th>
        		</tr>
        			<%
        				String username=(String)session.getAttribute("Username"); //get the username from the session object.
        				ArrayList<Addtocart> pl=ad.getproductlistfromcart(username);
        				Iterator<Addtocart> it=pl.iterator();
        				while(it.hasNext())
        				{
        					Addtocart p=it.next();
        					
        			%>
        			<tr>
        				<th><%=p.getCrtmodelname()%></th>
        				<th><%=p.getCrtgraphicscard() %></th>
        				<th><%=p.getCrtProcessor() %></th>
        				<th><%=p.getCrtram() %></th>
        				<th><%=p.getCrtprice() %></th>
        				<th> <a href="RemovefromCart?pridrem=<%=p.getCrtpid() %>&useremail=<%=username %>" ><button style="height:35px; background-color:green; color:white; border-radius:10px">Remove from cart</button>  </a>  </th>  <!-- --send the product id,and username to 
        																												Cart servlet to remove the products to cart-->
        			</tr>
        			<%
        				}
        			%>
	        </table>
	        <br>
	        <br>
	        <a href="Checkout.jsp"><button style="height:55px; background-color:green; color:white; border-radius:10px; width:100px; margin-left:1000px">Checkout</button></a>
        </div>

        <footer id="reg"><span>copy Copyright 2020</span></footer>
    </div>

</body>
</html>