<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
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
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
    }

    /* Flexbox to arrange quote in the middle */
    .content {
        text-align: center;
        flex: 1;
    }

    /* Quote styling with updated background, color, and reduced size */
    .quote {
        font-size: 1.2rem; /* Reduced text size */
        font-weight: bold;
        color: #8B0000; /* Dark Red */
        background-color: #FFFAF0; /* Ivory background */
        padding: 10px 1px;  /* Reduced padding for a smaller box */
        border-radius: 10px;
        margin-bottom: 15px;
        display: inline-block;  /* To make the flex box size fit the text */
    }

    /* Welcome text styling */
    h2 {
        text-align: center;
        font-size: 1.5rem; /* Medium text size */
        color: #333; /* Dark color for the welcome text */
        margin-bottom: -8px;
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

    /* Food image section */
    .food-images {
        display: flex;
        flex-direction: column;
        gap: 20px;
        justify-content: center;
        position: absolute;
    }

    /* Left images moved to the left */
    .food-images.left {
        left: 0; /* Move the left images to the very left */
        top: 20%;
    }

    /* Right images moved to the right */
    .food-images.right {
        right: 0; /* Move the right images to the very right */
        top: 20%;
    }

    .food-images img {
        width: 180px; /* Reduced size of images */
        height: 150px;
        object-fit: cover;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    /* Added gap between the quote and the signup text */
   .signup-links {
    margin-top: 30px; /* Adds gap between quote and signup links */
    margin-bottom: 20px; /* Adds gap between signup links and start ordering button */
}
   
</style>
</head>
<body>
    <!-- Welcome Text -->
    <h2>Welcome to RKFoods</h2>

    <div class="container">
        <!-- Content with the Quote and Links -->
        <div class="content">
            <!-- New Quote with updated background, color, and reduced size -->
            <p class="quote">"Enjoy every moment with delicious food!"</p>
            
            <!-- Links with green color (on new line) and gap added -->
            <div class="signup-links">
                <a href="Registration.jsp">Sign Up</a> | <a href="login.jsp">Login</a>
            </div><br><br>
            
           <a href="StartOrder.jsp">
                <button>Start Ordering</button>
             </a>
           
        </div>
        
        <!-- Left and Right Images Section -->
        <div class="food-images left">
            <img src="images/hyderabadi_biryani.jpg" alt="Hyderabadi Biryani">
            <img src="images/burger.png" alt="Burger">
        </div>

        <div class="food-images right">
            <img src="images/masala_dosa.jpg" alt="Masala Dosa">
            <img src="images/paneer_tikka.jpg" alt="Paneer Tikka">
        </div>
    </div>
</body>
</html>
