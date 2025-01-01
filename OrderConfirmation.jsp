<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Success</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }

        /* Header Styles */
        h1 {
            text-align: center;
            margin-top: 50px;
            color: #4CAF50;
        }

        /* Logout Button Styles */
        .logout-container {
            display: flex;
            justify-content: flex-end;
            margin: 20px;
            padding-right: 20px;
        }

        .logout-button {
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: #d9534f;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .logout-button:hover {
            background-color: #c9302c;
        }

        /* Footer Styles */
        footer {
            text-align: center;
            margin-top: 50px;
            font-size: 14px;
            color: #777;
        }
    </style>
</head>
<body>
    <!-- Main Content -->
    <h1>Order Success</h1>
    
    <!-- Logout Button -->
    <div class="logout-container">
        <a href="LogoutServlet" class="logout-button">Logout</a>
    </div>
    
    <footer>
        Thank you for shopping with us!
    </footer>
</body>
</html>
