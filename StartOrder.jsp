<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start Ordering</title>
<style>
    /* Set the background color for the page */
    body {
        background-color: #f0f8ff; /* Light blue */
        font-family: Arial, sans-serif;
        color: #333;
        margin: 0;
        padding: 0;
    }

    /* Center content */
    .container {
        width: 90%;
        margin: 0 auto;
        padding: 50px 0;
        text-align: center;
    }

    /* Heading and paragraph styling */
    h2 {
        font-size: 2rem;
        color: #333;
    }

    p {
        font-size: 1.2rem;
        margin-bottom: 20px;
    }

    /* Button styling */
    button {
        background-color: #FFC107; /* Warm yellow */
        color: white;
        border: none;
        padding: 12px 30px;
        font-size: 16px;
        cursor: pointer;
        border-radius: 25px;
        transition: background-color 0.3s ease, color 0.3s ease;
    }

    button:hover {
        background-color: #e68900; /* Darker yellow on hover */
    }

    /* Links styling (Green color) */
    a {
        color: #4CAF50; /* Green color for links */
        text-decoration: none;
        font-weight: bold;
        padding: 10px;
    }

    a:hover {
        color: #45a049; /* Darker green on hover */
    }

    /* Warning message styling */
    .warning {
        font-size: 1.2rem;
        color: red;
        margin-top: 20px;
    }

    .signup-links {
        margin-top: 30px;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Start Ordering</h2>

        
            <p>Please log in to start ordering.</p>
            <div class="signup-links">
                <a href="login.jsp">Login</a> | <a href="Registration.jsp">Sign Up</a>
            </div>
            <p class="warning">If you don't have an account, please sign up .</p>
        
    </div>
</body>
</html>
