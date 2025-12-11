<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>User Registration</title>

  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

  <style>
    :root{
      --bg-1: #eef2ff;            
      --card-bg: #ffffffd9;       
      --accent-1: #4f46e5;        
      --accent-2: #6366f1;        
      --muted: #6b7280;          
      --label: #5b5f70;          
      --input-bg: #f8f9ff;        
      --radius: 14px;
      --shadow: 0 10px 30px rgba(79,70,229,0.15);
      --shadow-light: 0 4px 14px rgba(79,70,229,0.1);
    }

    * { box-sizing: border-box; }
    body{
      margin:0;
      display:flex;
      height:100vh;
      align-items:center;
      justify-content:center;
      font-family:'Poppins',sans-serif;
      background: linear-gradient(135deg,#eef2ff,#e0e7ff);
      padding:20px;
    }

    .wrap{
      width:100%;
      max-width:490px;
      padding:32px;
      background:var(--card-bg);
      border-radius:var(--radius);
      backdrop-filter:blur(8px);
      box-shadow:var(--shadow);
      animation:fadeIn .35s ease;
      border:1px solid rgba(255,255,255,0.55);
    }

    .header{
      display:flex;
      gap:14px;
      align-items:center;
      margin-bottom:22px;
    }

    .logo{
      width:48px; 
      height:48px; 
      border-radius:12px;
      background:linear-gradient(135deg,var(--accent-1),var(--accent-2));
      display:flex;
      align-items:center;
      justify-content:center;
      color:#fff;
      font-size:18px;
      font-weight:700;
      box-shadow:var(--shadow-light);
    }

    h2{ margin:0; font-size:22px; font-weight:700; color:#1e1e2f; }
    p.lead{ margin:4px 0 16px; font-size:14px; color:var(--muted); }


    form{
      display:flex;
      flex-direction:column;
      gap:20px;
    }


    .field{
      width:100%;
      position:relative;
    }

    .field input,
    .field select{
      width:100%;
      padding:14px 12px;
      border-radius:12px;
      border:1px solid #d3d6f6;
      background:var(--input-bg);
      font-size:15px;
      color:#1e1e2f;
      outline:none;
      transition:.2s;
      -webkit-appearance:none;
      -moz-appearance:none;
      appearance:none;
    }

    .field select:invalid {
      color: var(--muted);            
    }


    .field select:valid {
      color: #0b1020;                 
    }

    .field select{
      background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg fill='%236366f1' height='24' viewBox='0 0 24 24' width='24' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M7 10l5 5 5-5z'/%3E%3C/svg%3E");
      background-repeat:no-repeat;
      background-position:right 12px center;
      background-size:18px;
      padding-right:40px; 
    }

    .field select option {
      color: #0b1020;
      background: #fff;
    }

    .field label{
      position:absolute;
      top:50%;
      left:12px;
      transform:translateY(-50%);
      background:var(--input-bg);
      padding:0 6px;
      color:var(--label);
      font-size:14px;
      pointer-events:none;
      transition:.2s;
    }

    .field input:focus,
    .field select:focus{
      border-color:var(--accent-1);
      box-shadow:var(--shadow-light);
      background:#f4f5ff;
    }

    .field input:not(:placeholder-shown) + label,
    .field input:focus + label,
    .field select:focus + label,
    .field select:valid + label{
      top:-2px;
      transform:translateY(-50%) scale(.88);
      color:var(--accent-1);
      font-weight:500;
    }

    .note{
      font-size:12px;
      color:var(--muted);
      margin-top:4px;
    }

    .btn{
      padding:14px;
      background:linear-gradient(90deg,var(--accent-1),var(--accent-2));
      border:none;
      border-radius:12px;
      color:#fff;
      font-size:15px;
      cursor:pointer;
      font-weight:600;
      transition:.15s ease;
    }
    .btn:hover{
      transform:translateY(-2px);
      box-shadow:var(--shadow);
    }

    .helper{
      text-align:center;
      font-size:13px;
      color:var(--muted);
    }
    .helper a{
      color:var(--accent-1);
      font-weight:600;
      text-decoration:none;
    }

    .error{
      width:100%;
      text-align:center;
      background:#fde4e4;
      border:1px solid #f5baba;
      padding:10px;
      border-radius:10px;
      font-size:13px;
      color:#c0392b;
      margin-bottom:10px;
    }

    @keyframes fadeIn{
      from{opacity:0; transform:translateY(10px);}
      to{opacity:1; transform:none;}
    }
  </style>
</head>

<body>

  <div class="wrap">
    <div class="header">
      <div class="logo">US</div>
      <div>
        <h2>Create Account</h2>
        <p class="lead">Register to continue</p>
      </div>
    </div>

    <form action="callingUserRegistrationServlet" method="post" novalidate>

      <div class="field">
        <input type="text" name="name" id="name" required placeholder=" ">
        <label for="name">Full Name</label>
      </div>

      <div class="field">
        <input type="email" name="email" id="email" required placeholder=" ">
        <label for="email">Email Address</label>
      </div>

      <div class="field">
        <input type="tel" name="phonenumber" id="phone" pattern="[0-9]{10}" required placeholder=" ">
        <label for="phone">Phone Number (10 digits)</label>
        <div class="note">Example: 9876543210</div>
      </div>

      <div class="field">
        <input type="password" name="password" id="password" minlength="6" required placeholder=" ">
        <label for="password">Password</label>
      </div>

      <div class="field">
        <input type="text" name="address" id="address" placeholder=" ">
        <label for="address">Address (optional)</label>
      </div>

      <div class="field">
       
        <select name="role" id="role" required>
          <option value="" disabled selected hidden>Select role</option>
          <option value="customer">Customer</option>
          <option value="restaurantadmin">Restaurant Admin</option>
          <option value="deliveryagent">Delivery Agent</option>
          <option value="superadmin">Super Admin</option>
        </select>
        <label for="role">Role</label>
      </div>

      <button class="btn" type="submit">Register</button>

      <div class="helper">
        Already have an account? <a href="login.jsp">Login</a>
      </div>

    </form>
  </div>

</body>
</html>
