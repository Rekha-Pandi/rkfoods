<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.rkfoods.model.Cart" %>
<%@ page import="com.rkfoods.model.CartItem" %>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null || cart.getAllItems().isEmpty()) {
        out.print("<p>Your cart is empty. Please add items to your cart before proceeding to payment.</p>");
        out.print("<a href='cart.jsp'>Go to Cart</a>");
        return;
    }

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new java.util.Locale("en", "IN"));
    double totalAmount = cart.calculateTotal();
    Map<Integer, CartItem> cartItems = cart.getAllItems();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            color: #333;
        }
        .payment-container {
            width: 90%;
            margin: 30px auto;
            max-width: 800px;
            background-color: #fff;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1, h3 {
            text-align: center;
            color: #2c3e50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table th, table td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        table th {
            background-color: #f4f4f4;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 8px;
        }
        input[type="text"], select, textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-sizing: border-box;
        }
        textarea {
            height: 100px;
        }
        button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="payment-container">
        <h1>Payment Details</h1>
        <h3>Order Summary</h3>
        <table>
            <thead>
                <tr>
                    <th>Item Name</th>
                    <th>Price (₹)</th>
                    <th>Quantity</th>
                    <th>Sub-Total (₹)</th>
                </tr>
            </thead>
            <tbody>
                <% for (Map.Entry<Integer, CartItem> entry : cartItems.entrySet()) {
                    CartItem item = entry.getValue();
                %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td><%= currencyFormatter.format(item.getPrice()) %></td>
                    <td><%= item.getQuantity() %></td>
                    <td><%= currencyFormatter.format(item.getSubTotal()) %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <h3>Total: <%= currencyFormatter.format(totalAmount) %></h3>

        <form action="OrderTableServlet">
            <div class="form-group">
                <label for="address">Delivery Address</label>
                <textarea id="address" name="address" placeholder="Enter your delivery address" required aria-label="Delivery Address"></textarea>
            </div>
            <div class="form-group">
                <label for="paymentMethod">Select Payment Method</label>
                <select id="paymentMethod" name="paymentMethod" required aria-label="Payment Method">
                    <option value="Cash on Delivery">Cash on Delivery</option>
                    <option value="UPI">UPI</option>
                    <option value="Card">Card</option>
                </select>
            </div>
            <div class="form-group" style="text-align: center;">
                <button type="submit">Place Order</button>
            </div>
        </form>
    </div>
</body>
</html>
