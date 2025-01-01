<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rkfoods.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        /* Styles here */
        body {
            background-color: #f0f8ff;
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
        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }
        .menu-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            gap: 20px;
        }
        .menu-item {
            background-color: #ffffff;
            border-radius: 8px;
            padding: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 250px;
            transition: transform 0.3s ease;
        }
        .menu-item img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
            transition: transform 0.3s ease;
        }
        .menu-item p {
            margin: 5px 0;
            color: #34495e;
            font-weight: bold;
        }
        .price {
            color: #e91e63;
            font-weight: bold;
        }
        .menu-item:hover {
            transform: scale(1.05);
        }
        .menu-item:hover img {
            transform: scale(1.1);
        }
        .add-to-cart-button {
            display: inline-block;
            padding: 5px 15px;
            margin-top: 10px;
            background-color: #ff9800;
            color: white;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            font-size: 14px;
            cursor: pointer;
        }
        .add-to-cart-button:hover {
            background-color: #e65100;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Restaurant Menu</h1>
        <div class="menu-grid">
            <% 
                ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("menuList");
                if (menuList != null) {
                    for (Menu menu : menuList) {
            %>
                        <div class="menu-item">
                            <img src="<%= request.getContextPath() + menu.getImgPath() %>" alt="<%= menu.getMenuName() %>" class="menu-image">
                            <h4><%= menu.getMenuName() %></h4>
                            <p><%= menu.getDescription() %></p>
                            <p class="price">₹<%= menu.getPrice() %></p>
                            <form action="AddToCart" method="post">
                                <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                                <input type="hidden" name="restaurantId" value="<%= menu.getRestaurantId() %>">
                                <input type="hidden" name="name" value="<%= menu.getMenuName() %>">
                                <input type="hidden" name="price" value="<%= menu.getPrice() %>">
                                <label for="quantity-<%= menu.getMenuId() %>">Quantity:</label>
                                <input type="number" id="quantity-<%= menu.getMenuId() %>" name="quantity" min="1" value="1" required>
                                <button type="submit" class="add-to-cart-button">Add to Cart</button>
                            </form>
                        </div>
            <% 
                    }
                } else {
            %>
                    <p>No menu items available.</p>
            <% 
                } 
            %>
        </div>
    </div>
</body>
</html>
