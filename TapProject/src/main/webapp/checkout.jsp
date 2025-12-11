<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User" %>
<%
    // Get the logged-in user from session
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>Checkout</title>
<style>
  :root{
    --bg:#0f1724;
    --card:#0b1220;
    --muted:#94a3b8;
    --accent:#06b6d4;
    --glass: rgba(255,255,255,0.04);
    --radius:12px;
  }

  *, *::before, *::after { box-sizing: border-box; }

  html, body{
    height:100%;
    margin:0;
    font-family: Inter, Arial, sans-serif;
    background:var(--bg);
    color:#e6eef6;
    font-size:16px;  
  }

  /* Header */
  header {
    width:100%;
    background:#111827;
    padding:10px 20px;
    display:flex;
    align-items:center;
    justify-content:space-between;
    color:#fff;
    box-shadow:0 2px 5px rgba(0,0,0,0.3);
  }

  header a {
    color:#fff;
    text-decoration:none;
    font-weight:700;
  }

  .user-info {
    display:flex;
    align-items:center;
    gap:10px;
  }

  .user-info img {
    width:36px;
    height:36px;
    border-radius:50%;
    object-fit:cover;
  }

  /* Page and card */
  .page{
    min-height:100%;
    display:flex;
    align-items:center;
    justify-content:center;
    padding:20px;
    margin-top:20px; /* space below header */
  }

  .card{
    width:400px;
    max-width:95vw;
    background:var(--card);
    border:1px solid var(--glass);
    border-radius:var(--radius);
    padding:25px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.6);
  }

  h2{
    margin:0 0 15px 0;
    color:var(--accent);
    font-size:26px;   
    font-weight:800;
  }

  form { 
    display:flex; 
    flex-direction:column; 
    gap:15px; 
  }

  form > div {
    display: flex;
    flex-direction: column;
    gap:8px; /* space between label and input */
  }

  label {
    font-size:16px;   
    color:var(--muted);
    font-weight:600;
    display:block;
  }

  input[type="text"],
  input[type="tel"],
  textarea,
  select {
    width:100%;
    padding:14px 14px;
    border-radius:10px;
    background:var(--card);            
    border:1px solid var(--glass);
    color:#e6eef6;
    font-size:18px;                    
    outline:none;
  }

  textarea { min-height:110px; }

  select {
    background: #131b2b;               
    cursor:pointer;
  }

  input:focus, textarea:focus, select:focus {
    border-color:var(--accent);
    box-shadow: 0 8px 24px rgba(6,182,212,0.08);
  }

  .place-btn{
    margin-top:10px;
    width:100%;
    padding:14px;
    border-radius:10px;
    border:0;
    background:linear-gradient(90deg,var(--accent), #1dd3d9);
    color:#001219;
    font-weight:800;
    font-size:20px;
    cursor:pointer;
  }
  
  .header{
  	padding:8px 18px; 
  	background:#06b6d4; 
  	color:#000; 
  	border-radius:8px;
   	font-weight:700; 
   	text-decoration:none;
  }
  .user-box {
    position: absolute;
    top: 60px;
    right: 20px;
    width: 240px;
    padding: 15px;
    background: #ffffff;
    border-radius: 8px;
    display: none;
    border: 1px solid #dcdcdc;
    box-shadow: 0px 4px 10px rgba(0,0,0,0.15);
    z-index: 200;
}

.user-box h3 {
    margin-top: 0;
    margin-bottom: 10px;
    font-size: 18px;
}

.user-box button {
    margin-top: 10px;
    width: 100%;
    padding: 8px;
    border-radius: 5px;
    border: none;
    background: #111827;
    color: white;
    cursor: pointer;
}
.top-nav {
    position: absolute;
    top: 20px;
    right: 20px;
    display: flex;
    gap: 20px;
    align-items: center;
}

.icon-btn {
    width: 32px;
    height: 32px;
    cursor: pointer;
    transition: transform 0.2s ease;
}

.icon-btn:hover {
    transform: scale(1.15);
}

.user-menu {
    position: relative;
    display: inline-block;
}

.user-box {
    display: none;
    position: absolute;
    top: 40px;
    right: 0;
    background: #0d1220;
    color: white;
    width: 180px;
    padding: 12px;
    border-radius: 8px;
    border: 1px solid #2c3e50;
    box-shadow: 0 4px 14px rgba(0,0,0,0.4);
    z-index: 999;
}

.user-menu:hover .user-box {
    display: block;
}

.user-box a {
    color: #00eaff;
    text-decoration: none;
    margin-top: 10px;
    display: block;
}


@keyframes fadeIn {
    from { opacity: 0; transform: translateY(-5px); }
    to   { opacity: 1; transform: translateY(0); }
}

  
</style>
</head>
<body>

<div class="top-nav">
    <a href="Restaurant">
        <img src="images/home.png" class="icon-btn" alt="Home">
    </a>

    <% if (user != null) { %>
        <div class="user-menu">
            <img src="images/user.png" class="icon-btn" alt="User">
            <div class="user-box">
                <p><strong>Name:</strong> <%= user.getUserName() %></p>
                <p><strong>Email:</strong> <%= user.getEmail() %></p>
                <a href="logout">Logout</a>
            </div>
            

        </div>
    <% } else { %>
        <a href="login.jsp">
            <img src="images/user.png" class="icon-btn" alt="Login">
        </a>
    <% } %>
</div>

<!-- Page Content -->
<div class="page">
    <div class="card">
        <h2>Checkout</h2>

        <form action="checkout" method="post">

            <div>
              <label>Full name</label>
              <input type="text" name="fullname" placeholder="Full name" required>
            </div>

            <div>
              <label>Address</label>
              <textarea name="address" placeholder="House no., street, landmark, city, pincode" required></textarea>
            </div>

            <div>
              <label>Phone</label>
              <input type="tel" name="phone" placeholder="10-digit mobile number" required>
            </div>

            <div>
              <label>Payment method</label>
              <select required name="paymentMethod">
                <option value="" disabled selected>Select payment</option>
                <option>Cash on Delivery</option>
                <option>UPI</option>
                <option>Credit / Debit Card</option>
                <option>Netbanking</option>
              </select>
            </div>

            <button class="place-btn" type="submit">Place Order</button>

        </form>
    </div>
</div>
<script>
function toggleUserBox() {
    const box = document.getElementById('userBox');
    box.style.display = (box.style.display === 'block') ? 'none' : 'block';
}
</script>
</body>
</html>
