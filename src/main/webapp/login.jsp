<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
   
    body {
        background-image: url('<%=request.getContextPath()%>/images/res.jpg');
        background-size: cover; 
        background-position: center;
        font-family: Arial, sans-serif;
        color: #34495E; 
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;  
        align-items: center;      
        height: 100vh;            
    }

    
    .container {
        width: 300px; 
        padding: 12px 10px; 
        text-align: center;
        background-color: #D6EAF8;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

    h2 {
        color: #34495E; /* Dark gray color for headings */
        font-size: 22px;
        margin-bottom: 15px; /* Reduced margin for the heading */
    }

    /* Form container styling */
    form {
        width: 100%;
    }

    /* Table layout for better alignment */
    table {
        width: 100%;
        margin: 0 auto;
        border-collapse: collapse;
        text-align: left;
    }

    td {
        padding: 8px;
        font-size: 14px;
    }

    /* Input styling */
    td input[type="text"], td input[type="password"] {
        width: 100%;  /* Full width for textboxes */
        padding: 8px 10px; /* Reduced padding to make the box more compact */
        margin: 8px 0;
        border: 2px solid #BDC3C7;
        border-radius: 5px;
        font-size: 12px; /* Reduced font size */
        box-sizing: border-box;
    }

    /* Submit button styling (WhatsApp green color) */
    input[type="submit"] {
        background-color: #25D366; /* WhatsApp green color */
        color: white;
        border: none;
        padding: 12px 30px;
        font-size: 16px;
        cursor: pointer;
        border-radius: 25px;
        transition: background-color 0.3s ease, color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #128C7E; /* Darker WhatsApp green on hover */
    }

    /* Links styling */
    a {
        color: #25D366; /* WhatsApp green color for links */
        text-decoration: none;
        font-weight: bold;
        padding: 10px;
    }

    a:hover {
        color: #128C7E; /* Darker WhatsApp green on hover */
    }

    /* Prevent line break for "Don't have an account?" text */
    p {
        white-space: nowrap; /* Prevent text from breaking to the next line */
        font-size: 14px;  /* Reduce font size to avoid overflow */
    }
</style>
</head>
<body>
    <!-- Right Side Form Section -->
    <div class="container">
        <h2>Login</h2>
        <form action="LoginServlet">
            <table>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="text" id="email" name="email" placeholder="Enter your email" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" id="password" name="password" placeholder="Enter your password" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
        <br>
        <p>Don't have an account? <a href="Registration.jsp">Sign Up</a></p>
    </div>
</body>
</html>






