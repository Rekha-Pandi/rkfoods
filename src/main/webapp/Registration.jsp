<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
    /* Set the background color for the page */
    body {
        background-color: #f0f8ff; /* Light blue */
        font-family: Arial, sans-serif;
        color: #333;
        margin: 0;
        padding: 0;
    }

    /* Center the registration form */
    .container {
        width: 30%;  /* Reduced width */
        margin: 20px auto;  /* Reduced space between registration and form */
        padding: 15px;
        background-color: #FFFAF0; /* Ivory background */
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
    }

    /* Form header */
    h2 {
        text-align: center;
        font-size: 1.3rem;  /* Reduced font size */
        color: #333;
        margin-bottom: 8px;  /* Reduced space between header and form */
    }

    /* Table styling */
    table {
        width: 100%;
    }

    td {
        padding: 4px 6px;  /* Reduced padding between rows */
    }

    label {
        font-size: 0.8rem;  /* Smaller label text */
        font-weight: bold;
        margin-right: 5px;  /* Reduced space between label and input */
    }

    /* Specific styling for Phone Number label to reduce its width */
    label[for="phoneNumber"] {
        font-size: 0.75rem; /* Smaller text size for "Phone Number" */
    }

    input[type="text"], input[type="password"] {
        padding: 6px;  /* Reduced input box padding */
        margin-top: 3px;  /* Reduced top margin */
        font-size: 0.85rem;  /* Smaller font size for inputs */
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        width: 98%;  /* Reduced width of input boxes */
    }

    /* Submit button styling */
    input[type="submit"] {
        background-color: #FFC107; /* Warm yellow */
        color: white;
        padding: 8px 20px;  /* Adjusted padding */
        font-size: 0.9rem;  /* Reduced font size */
        border: none;
        cursor: pointer;
        border-radius: 25px;
        transition: background-color 0.3s ease, color 0.3s ease;
        width: 100%;
        margin-top: 15px;  /* Reduced space above the button */
    }

    input[type="submit"]:hover {
        background-color: #e68900; /* Darker yellow on hover */
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Registration</h2>
        <form action="RegistrationServlet" method="POST">
            <table>
                <tr>
                    <td><label for="userName">User Name:</label></td>
                    <td><input type="text" name="userName" required></td>
                </tr>
                <tr>
                    <td><label for="phoneNumber">Phone Number:</label></td>
                    <td><input type="text" name="phoneNumber" required></td>
                </tr>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="text" name="email" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="password" id="password" name="password" required></td>
                </tr>
                <tr>
                    <td><label for="address">Address:</label></td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
