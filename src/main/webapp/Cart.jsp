<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.rkfoods.model.Cart" %>
<%@ page import="com.rkfoods.model.CartItem" %>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null || cart.getAllItems().isEmpty()) {
        out.print("<p>Your cart is empty. Please add items to your cart.</p>");
        return;
    }

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new java.util.Locale("en", "IN"));
    double totalAmount = cart.calculateTotal();
    Map<Integer, CartItem> cartItems = cart.getAllItems();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart</title>
    <style>
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
        .cart-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            gap: 20px;
        }
        .cart-item {
            background-color: #ffffff;
            border-radius: 8px;
            padding: 15px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            flex: 0 1 calc(30% - 20px);
            max-width: 300px;
            box-sizing: border-box;
        }
        .menu-name {
            font-size: 18px;
            font-weight: bold;
            color: #34495e;
            margin-bottom: 5px;
        }
        .price {
            font-size: 16px;
            color: #e91e63;
            font-weight: bold;
            margin-bottom: 10px;
        }
        .actions {
            display: flex;
            align-items: center;
            gap: 10px;
            margin-bottom: 10px;
        }
        .actions input[type="number"] {
            width: 50px;
            padding: 3px;
            text-align: center;
            font-size: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .actions button {
            padding: 5px 10px;
            font-size: 12px;
            background-color: #ff9800;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .actions button:hover {
            background-color: #e65100;
        }
        .subtotal {
            font-size: 14px;
            font-weight: bold;
            margin-top: 10px;
        }
        .total {
            font-weight: bold;
            font-size: 20px;
            margin-top: 20px;
            text-align: center;
        }
        .button-group {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 20px;
        }
        .button-group button {
            display: block;
            width: 200px;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button-group button:hover {
            background-color: #218838;
        }
        .menu-button {
            background-color: #007bff;
        }
        .menu-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Cart</h1>

        <div class="cart-grid">
            <% for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                CartItem item = entry.getValue();
            %>
            <div class="cart-item">
                <div class="menu-name"><%= item.getName() %></div>
                <div class="price">Price: ₹<%= item.getPrice() %></div>
                <div class="actions">
                    <form action="CartAction" method="post" style="display: flex; align-items: center; gap: 10px;">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <label for="quantity-<%= item.getMenuId() %>">Quantity:</label>
                        <input type="number" id="quantity-<%= item.getMenuId() %>" name="quantity" 
                               value="<%= item.getQuantity() %>" min="1" max="10" step="1" required>
                        <button type="submit">Update</button>
                    </form>
                    <form action="CartAction" method="post">
                        <input type="hidden" name="action" value="remove">
                        <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                        <button type="submit">Remove</button>
                    </form>
                </div>
                <div class="subtotal">
                    Sub-Total: <%= currencyFormatter.format(item.getSubTotal()) %>
                </div>
            </div>
            <% } %>
        </div>

        <div class="total">
            Total: <%= currencyFormatter.format(totalAmount) %>
        </div>

        <div class="button-group">
            <!-- Place Order button triggers the order placement process -->
            <form action="payment.jsp" method="POST">
                <button type="submit" class="checkout-button">Place Order</button>
            </form>
            <form action="menu.jsp" method="get">
                <button type="submit" class="menu-button">Go to Menu</button>
            </form>
        </div>
    </div>
</body>
</html>
