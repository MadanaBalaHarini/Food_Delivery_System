<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String errorMsg = null;
    if(session != null && session.getAttribute("loginError") != null) {
        errorMsg = (String) session.getAttribute("loginError");
        session.removeAttribute("loginError");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        height: 100vh;
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
    }

    .login-container {
        width: 360px;
        padding: 40px;
        border-radius: 20px;
        background: rgba(255, 255, 255, 0.12);
        backdrop-filter: blur(12px);
        box-shadow: 0 8px 32px rgba(0,0,0,0.25);
        animation: fadeIn 0.8s ease-in-out;
        color: white;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(20px); }
        to { opacity: 1; transform: translateY(0); }
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        font-size: 28px;
        font-weight: 600;
    }

    .input-box {
        position: relative;
        margin-bottom: 25px;
    }

    .input-box input {
        width: 100%;
        padding: 12px;
        border: none;
        background: rgba(255,255,255,0.15);
        border-radius: 10px;
        font-size: 16px;
        color: white;
        outline: none;
    }

    .input-box label {
        position: absolute;
        top: 50%;
        left: 12px;
        transform: translateY(-50%);
        font-size: 14px;
        color: #dfe6e9;
        transition: 0.3s;
        pointer-events: none;
    }

    .input-box input:focus + label,
    .input-box input:not(:placeholder-shown) + label {
        top: 0px;
        background: rgba(0,0,0,0.4);
        padding: 2px 6px;
        border-radius: 6px;
        font-size: 12px;
    }

    .login-btn {
        width: 100%;
        padding: 12px;
        border: none;
        background: #00b4db;
        background: linear-gradient(to right, #00b4db, #0083b0);
        color: white;
        font-size: 17px;
        border-radius: 10px;
        cursor: pointer;
        transition: 0.3s;
    }

    .login-btn:hover {
        transform: scale(1.03);
        background: linear-gradient(to right, #0083b0, #00b4db);
    }

    .error-msg {
        color: #ff6b6b;
        margin-bottom: 15px;
        text-align: center;
        font-size: 14px;
        font-weight: 500;
    }

    .register-link {
        display: block;
        margin-top: 15px;
        color: #74c0fc;
        text-align: center;
        text-decoration: none;
        font-size: 14px;
    }

    .register-link:hover {
        text-decoration: underline;
    }
</style>
</head>

<body>

<div class="login-container">

    <h2>Login</h2>

    <% if(errorMsg != null) { %>
        <div class="error-msg"><%= errorMsg %></div>
    <% } %>

    <form action="LoginValidation" method="post">

        <div class="input-box">
            <input type="email" name="email" required placeholder=" ">
            <label>Email</label>
        </div>

        <div class="input-box">
            <input type="password" name="password" required placeholder=" ">
            <label>Password</label>
        </div>

        <button type="submit" class="login-btn">Login</button>
    </form>

    <a href="registration.jsp" class="register-link">New user? Register here</a>
</div>

</body>
</html>
