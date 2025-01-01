<%@ page import="com.rkfoods.dao.OrderHistoryDao" %>
<%@ page import="com.rkfoods.daoimpl.OrderHistoryDaoImpl" %>
<%@ page import="com.rkfoods.model.OrderHistory" %>
<%@ page import="com.rkfoods.model.User" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
    <style>
        /* Page background */
        body {
            background-color: #f0f8ff; /* Light blue to match your project */
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        /* Main container */
        .container {
            max-width: 900px;
            margin: 50px auto;
            background-color: #ffffff; /* White background for contrast */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        /* Heading */
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Table styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #FFFFF0; /* Ivory background for the table */
            border-radius: 10px; /* Rounded corners */
            overflow: hidden;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            text-align: center;
            padding: 10px;
        }

        th {
            background-color: #4CAF50; /* Green color for headers */
            color: #fff; /* White text for headers */
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Light grey for even rows */
        }

        tr:hover {
            background-color: #ddd; /* Slightly darker grey on hover */
        }

        /* No orders message */
        .no-orders {
            text-align: center;
            color: #777;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Order History</h2>

        <%
            User user = (User) session.getAttribute("loggedInUser");
            OrderHistoryDao orderHistoryDao = new OrderHistoryDaoImpl();
            ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();

            if (user != null) {
                // If user is logged in, fetch orders by userId
                orderHistoryList = orderHistoryDao.getOrderHistoryByUserId(user.getUserId());
            } else {
                // If user is not logged in, fetch orders made by guest users
                orderHistoryList = orderHistoryDao.getGuestOrderHistory();
            }

            // Check if the order history list is empty
            if (orderHistoryList != null && !orderHistoryList.isEmpty()) {
        %>
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>User ID</th>
                            <th>Order Date</th>
                            <th>Total Amount</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            for (OrderHistory order : orderHistoryList) {
                        %>
                        <tr>
                            <td><%= order.getOrderId() %></td>
                            <td><%= order.getUserId() %></td>
                            <td><%= order.getOrderDate() %></td>
                            <td><%= order.getTotalAmount() %></td>
                            <td><%= order.getStatus() %></td>
                        </tr>
                        <% 
                            }
                        %>
                    </tbody>
                </table>
        <% 
            } else {
        %>
                <p class="no-orders">You don't have any orders.</p>
        <% 
            }
        %>
    </div>
</body>
</html>
