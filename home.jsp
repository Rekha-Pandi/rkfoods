<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rkfoods.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rkfoods.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    body {
        background-color: #f0f8ff; /* Light blue */
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        color: #333;
    }
    .container {
        width: 90%;
        margin: 0 auto;
        padding: 20px;
    }
    h3 {
        text-align: center;
        color: #2c3e50;
    }
    h4 {
        color: #2c3e50;
        margin-bottom: 20px;
    }
    .restaurant-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        gap: 20px;
    }
    .restaurant-item {
        background-color: #ffffff;
        border-radius: 8px;
        padding: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 200px;
        transition: transform 0.3s ease;
    }
    .restaurant-item img {
        width: 100%;
        height: auto;
        border-radius: 8px;
        transition: transform 0.3s ease;
    }
    .restaurant-item p {
        margin: 5px 0;
        color: #34495e;
        font-weight: bold;
    }
    .restaurant-item:hover {
        transform: scale(1.05);
    }
    .restaurant-item:hover img {
        transform: scale(1.1);
    }
    .view-menu-button {
        display: inline-block;
        padding: 5px 15px;
        margin-top: 10px;
        background-color: #00c853;
        color: white;
        border-radius: 5px;
        text-decoration: none;
        font-weight: bold;
        font-size: 14px;
    }
    .view-menu-button:hover {
        background-color: #009624;
    }
    @media (max-width: 768px) {
        .restaurant-item {
            width: 100%;
        }
    }
    /* Styling for the user greeting and order history button */
    .header-section {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }
    .order-history-btn {
        padding: 10px 20px;
        background-color: #3498db;
        color: white;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        font-weight: bold;
        cursor: pointer;
    }
    .order-history-btn:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>
    <div class="container">
        <%
            User user = (User) session.getAttribute("loggedInUser");
            ArrayList<Restaurant> restaurantList = (ArrayList<Restaurant>) session.getAttribute("restaurantList");
        %>
        
        <% if (user != null) { %>
            <!-- Header Section: Welcome Message + OrderHistory Button -->
            <div class="header-section">
                <h3>Welcome back, <%= user.getUserName() %>!</h3>
                <a href="OrderHistory.jsp" class="order-history-btn">Order History</a>
            </div>

            <% if (restaurantList != null && !restaurantList.isEmpty()) { %>
                <h4>Available Restaurants:</h4>
                <div class="restaurant-list">
                    <% for (Restaurant restaurant : restaurantList) { %>
                        <div class="restaurant-item">
                            <img src="<%=request.getContextPath() %>/images/<%= restaurant.getRestaurantName().toLowerCase().replace(" ", "_") %>.jpg" 
                                 alt="<%= restaurant.getRestaurantName() %>"/>
                            <p><%= restaurant.getRestaurantName() %></p>
                            <p><%= restaurant.getCuisineType() %></p>
                            <p>
                                Rating: &#9733; <%= restaurant.getRating() %>
                            </p>
                            <a href="ViewMenu?restaurantId=<%= restaurant.getRestaurantId() %>" class="view-menu-button">View Menu</a>
                        </div>
                    <% } %>
                </div>
            <% } else { %>
                <p>No restaurants available.</p>
            <% } %>

        <% } else { %>
            <h3>You haven't logged in.</h3>
        <% } %>
    </div>
</body>
</html>
