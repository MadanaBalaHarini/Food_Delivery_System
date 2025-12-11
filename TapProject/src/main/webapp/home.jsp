<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.tap.model.Restaurant,com.tap.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Page</title>
<link rel="stylesheet" href="home1.css"/>
</head>
<body>
  <div class="container">
    <header class="topbar">
      <div class="logo">Food Delivery</div>
      <nav class="nav">
        <a href="#" class="nav-link">Home</a>

        <a href="help.jsp" class="nav-link">Help</a>
        <a href="cart.jsp" class="nav-link">Cart</a>

      <% 
      User user = (User) session.getAttribute("user"); %>
      <div class="menu-header-right">
    <%
      if (user != null) {
    %>
      <div class="user-topbar-inline">
        <img src="images/user.png" alt="avatar" class="user-avatar">
        <div class="user-meta">
          <div class="user-name"><%= user.getUserName() %></div>
          <div class="user-email"><%= user.getEmail() %></div>
        </div>
        <div class="user-actions">
          <a href="logout" class="btn small outline">Logout</a>
        </div>
      </div>
    <%
      } else {
    %>
      <a href="login.jsp" class="login-link" title="Login">
        <img src="images/user.png" alt="Login" class="icon-btn">
      </a>
    <%
      }
    %>
  </div>
        </nav>
    </header>
    <main class="grid">  
        <%
        	    List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("allRestaurants");
        	    if (restaurants == null) {
        	        restaurants = new java.util.ArrayList<Restaurant>(); // empty list to avoid null
        	    }

        	    for (Restaurant r : restaurants) {
        
        %>
	<article class="card card-vertical">
 	 
 	 <a href="menu?restaurantId=<%= r.getRestaurantid() %>" class="card-link">
 	 
    	<figure class="thumb thumb-vertical">
      		<img src="<%= r.getImageurl() %>"  alt="Restaurant" />
    	</figure>
    	<div class="info info-vertical">
      	<div class="title"><%= r.getRestaurantname() %></div>
      	<div class="address"><%= r.getAddress() %></div>
      	<div class="description"><%= r.getCuisine() %></div>
      	<div class="meta" style="margin-top:10px; display:flex; gap:12px; align-items:center;">
        	<div class="rating" style="background:#48c479; padding:6px 10px; border-radius:6px; color:#fff; font-weight:700;"><%= r.getRating() %> ★</div>
        	<div class="eta" style="background:#ffa733; padding:6px 10px; border-radius:6px; color:#000; font-weight:700;"><%= r.getDeliverytime() %> min</div>
      	</div>
    	</div>
  	 </a>
	</article>
			
        <% } %>
        
    </main>
  </div>
</body>
</html>