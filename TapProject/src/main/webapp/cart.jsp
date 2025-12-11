<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart,com.tap.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<style>

:root{
    --bg:#0B1320;
    --card:#111827;
    --muted:#6B7280;
    --item-bg:#1F2937;
    --accent:#06B6D4;
    --accent-hover:#0891B2;
    --price:#FACC15;
    --text:#FFFFFF;
    --radius:12px;
    --gap:12px;
    --shadow: 0 6px 20px rgba(0,0,0,0.45);
    --container-w:420px;
}

*{box-sizing:border-box}
body {
    margin:0;
    font-family: Arial, Helvetica, sans-serif;
    background:var(--bg);
    color:var(--text);
    -webkit-font-smoothing:antialiased;
    -moz-osx-font-smoothing:grayscale;
    padding:24px 12px;
    display:flex;
    justify-content:center;
}


.cart-box{
    width:100%;
    max-width:var(--container-w);
    background:var(--card);
    padding:26px;
    border-radius:18px;
    box-shadow:var(--shadow);
}


.cart-title {
    font-size: 22px;
    font-weight: 800;
    color: #06B6D4;
    
}

.cart-sub{ 
	font-size:18px; 
	color:var(--muted); 
	margin-bottom:18px; 
}

.item{
    background:var(--item-bg);
    padding:16px;
    border-radius:14px;
    margin-bottom:16px;
    display:flex;
    flex-direction:column;
    gap:10px;
}

.item-top{
    display:flex;
    align-items:flex-start;
    gap:12px;
}

.item-name {
    font-size: 18px;
    color: #E5E7EB;
	font-weight: 600;
    
}

.item-desc{
	font-size:13px; 
	color:var(--muted); 
	margin-top:2px; 
}
.item-price{ 
	color:var(--price); 
	font-size:18px;
	font-weight:700; 
}

.qty-row{
    display:flex;
    align-items:center;
    gap:10px;
    width:100%;
    margin-top:6px;
}

.qty-controls{
    display:flex;
    align-items:center;
    gap:8px;
    background:transparent;
}

.qty-btn{
    width:34px;
    height:34px;
    border-radius:8px;
    border:none;
    background:#374151;
    color:var(--text);
    font-size:18px;
    cursor:pointer;
    display:inline-flex;
    align-items:center;
    justify-content:center;
    padding:0;
}
.qty-btn:disabled{ 
	opacity:0.45; 
	cursor:not-allowed; 
}
.qty-btn:hover:not(:disabled){
	 background:#4B5563; 
}

.qty-number{
    min-width:28px;
    text-align:center;
    font-size:15px;
    font-weight:600;
}

.delete-btn{
    margin-left:auto;
    background:none;
    border:none;
    color:#FF4D4D;
    cursor:pointer;
    font-weight:700;
    padding:6px 8px;
    border-radius:8px;
}
.delete-btn:hover{
 	background: rgba(255,255,255,0.03); 
 }

.summary-row
{ 
	display:flex; 
	justify-content:space-between;
	margin:8px 0; 
	color:var(--muted);
	font-size:14px;
}
.total-row{
	display:flex; 
	justify-content:space-between; 
	margin-top:12px;
	font-size:18px;
	font-weight:800; 
}

.btn{
    display:inline-block;
    width:100%;
    padding:12px 14px;
    font-size:15px;
    border-radius:10px;
    border:none;
    cursor:pointer;
    font-weight:700;
    text-decoration:none;
    text-align:center;
}

.grand-total {
	color: #F7B500;
    font-weight: 800;
    font-size: 20px;
}

.grand-total-label {
    font-weight: 800;
    color: #F4C542;  
    font-size: 18px;
}


.add-btn{
    background:var(--accent);
    color:#071017;
}
.add-btn:hover{
	 background:var(--accent-hover); 
}

.btn a{
	 color:inherit; 
	 text-decoration:none; 
	 display:block;
	 width:100%; 
}

@media (max-width:440px){
    :root{ --container-w:360px; }
    .cart-box{ padding:18px; }
    .item{ padding:12px; }
}
</style>
</head>

<body>
<div class="cart-box">
    <div class="cart-title">Your Cart</div>
    <div class="cart-sub">Review items and checkout</div>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId = (Integer) session.getAttribute("restaurantId");

    if (cart != null && !cart.getItems().isEmpty()) {
        for (CartItem item : cart.getItems().values()) {
%>

    <div class="item">
        <div class="item-top">
            <div style="flex:1;">
                <div class="item-name"><%= item.getName() %></div>
            </div>
        </div>

        <div class="item-price">Price: ₹<%= item.getPrice() %></div>

        <div class="qty-row">
            <div class="qty-controls">
                <!-- Increase -->

				<form action="callingCartServlet" method="post">
				    <input type="hidden" name="itemId" value="<%= item.getId() %>">
				    <input type="hidden" name="action" value="update">
				    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">

				    <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
				    
				    <button class="qty-btn" type="submit" aria-label="Increase quantity">+</button>
				</form>
				
                <span class="qty-number"><%= item.getQuantity() %></span>

                <!-- Decrease -->
                <form action="callingCartServlet" method="post" style="margin:0;">
                    <input type="hidden" name="itemId" value="<%= item.getId() %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                   
                    <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                    
                    <button class="qty-btn" type="submit" <%= item.getQuantity() == 1 ? "disabled" : "" %> aria-label="Decrease quantity">-</button>
                </form>
            </div>
            

            <!-- Remove -->      
            <form action="callingCartServlet" method="post" style="margin:0;">
			    <input type="hidden" name="itemId" value="<%= item.getId() %>">

			    <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
			    
			    <input type="hidden" name="action" value="remove">
			    <button class="delete-btn" type="submit">Remove</button>
			</form>
        </div>

        <div style="margin-top:6px;"><b>Total: ₹<%= item.getTotalPrice() %></b></div>
    </div>

<%  }  %>

    <div class="summary-row">
        <div class="grand-total-label">Grand Total</div>
        <div class="grand-total"><b>₹<%= cart.getTotalPrice() %></b></div>
        
    </div>

   
    <a class="btn add-btn" href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>">+ Add More Items</a>
    
	
	<form action="checkout.jsp" method="post" style="margin-top:12px;">
    	<input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
    	<input type="submit" value="Proceed to Checkout" class="btn add-btn">
	</form>
	

<% } else { %>

    <p>Your cart is empty.</p>
    <div style="margin-top:12px;">
        <a class="btn add-btn" href="menu?restaurantId=<%=session.getAttribute("restaurantId")%>">Browse Items</a>
    </div>

<% } %>



</div>
</body>
</html>
