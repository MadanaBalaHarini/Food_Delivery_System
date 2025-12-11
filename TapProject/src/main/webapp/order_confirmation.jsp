<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<style>
    body {
        margin: 0;
        padding: 0;
        background: #fdf6e3;
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        flex-direction: column;
        overflow-x: hidden;
    }

    h1 {
        color: #ff6f00;
        font-size: 36px;
        margin-bottom: 20px;
    }

    p {
        font-size: 20px;
        color: #333;
        margin-bottom: 50px;
    }

    .scooter-container {
        position: relative;
        width: 100%;
        height: 100px;
    }

    .scooter {
        position: absolute;
        bottom: 0;
        left: -100px;
        width: 180px;
        height: 150px;
        background: url('images/scooter.png') no-repeat center center; 
        background-size: contain;
        animation: ride 5s linear forwards;
        
        
    }

    @keyframes ride {
        0% { left: -100px; transform: rotate(0deg);}
        25% { transform: rotate(5deg);}
        50% { left: calc(100% - 100px); transform: rotate(-5deg);}
        75% { transform: rotate(3deg);}
        100% { left: 100%; transform: rotate(0deg);}
    }

    .thank-msg {
        margin-top: 50px;
        font-size: 24px;
        color: #ff6f00;
        font-weight: bold;
    }
</style>
</head>
<body>
    <h1>Order Placed Successfully!</h1>
    <p>Your delicious food is on its way 🚀</p>

    <div class="scooter-container">
        <div class="scooter"></div>
    </div>

    <div class="thank-msg">Thank you for ordering!</div>

</body>
</html>
    