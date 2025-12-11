<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.model.Menu" %>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>Food Delivery — Menu</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;500;700;800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="menu.css"/>
</head>
<body>
  <div class="wrap">
    <header class="menu-header">
      <div>
        <div class="logo">Food Delivery — Menu</div>
        <div class="subtitle">Pick items and add to cart</div>
      </div>
      <div style="display:flex;gap:10px;align-items:center;">
        <input placeholder="Search items, e.g. biryani" style="padding:8px 12px;border-radius:10px;border:1px solid rgba(255,255,255,0.04);background:transparent;color:var(--muted);outline:none" />
        <button style="background:var(--gold);border:none;padding:8px 12px;border-radius:10px;font-weight:800;cursor:pointer">Search</button>
      </div>
    </header>

    <div class="section-title">Popular items</div>

    <main class="grid">
    
    <%
	    List<Menu> menuList = (List<Menu>) request.getAttribute("allMenu");
	    if (menuList == null) {
	        menuList = new java.util.ArrayList<Menu>();
	    }
	    for (Menu m : menuList) {
	%>

            <article class="menu-card">
      	        <div class="thumb">
      	          <img src="<%= m.getImageurl() %>" alt="image not found">
      	        </div>
      	        <div class="info-vertical">
      	          <div class="name"><%=m.getMenuname() %></div>
      	          <div class="desc"><%=m.getDescription() %></div>
      	        </div>
      	        <div class="tags">
      	          
      	          <div class="price">Price: ₹<%=m.getPrice() %></div>
      	        </div>
      	        <div class="controls">
      	          <input class="qty" type="number" min="1" value="1" aria-label="quantity">  
      	        	
      	        	<form action="callingCartServlet" method="get">

    					<input type="hidden" name="itemId" value="<%= m.getMenuid() %>">
    					<input type="hidden" name="restaurantId" value="<%= m.getRestaurantid() %>">
    					<input type="hidden" name="quantity" value="1">   					
    					<input type="hidden" name="action" value="add">
						<input type="submit" class="add-btn" value="Add To Cart">
					</form>    	          
      	        </div>    	        
      	     </article>
	<%
      	}	
	%>
    </main>
  </div>
</body>
</html>








    