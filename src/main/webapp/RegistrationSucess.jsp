<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
<style>
    /* Page background */
    body {
        background-color: #f0f8ff; /* Light blue */
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Success message box */
    .success-box {
        background-color: #fffae6; /* Light ivory */
        border: 2px solid #ffcc00; /* Gold border */
        border-radius: 15px;
        padding: 30px;
        text-align: center;
        width: 300px; /* Reduced size for compact design */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    /* Success text */
    .success-box h2 {
        color: #4caf50; /* Green text */
        font-size: 1.8rem;
        margin-bottom: 10px;
    }

    .success-box p {
        color: #333;
        font-size: 1rem;
        margin-bottom: 20px;
    }

    /* Login button */
    .success-box a {
        text-decoration: none;
    }

    .success-box button {
        background-color: #4caf50; /* Green */
        color: white;
        border: none;
        padding: 12px 20px;
        font-size: 1rem;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .success-box button:hover {
        background-color: #45a049; /* Darker green on hover */
    }
</style>
</head>
<body>
    <!-- Success Message Box -->
    <div class="success-box">
        <h2>Registration Successful!</h2>
        <p>You can now log in to your account.</p>
        <!-- Redirect to login page -->
        <a href="login.jsp">
            <button>Login</button>
        </a>
    </div>
</body>
</html>
