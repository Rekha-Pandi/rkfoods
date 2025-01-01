package com.rkfoods.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkfoods.model.Cart;
import com.rkfoods.model.CartItem;
import com.rkfoods.model.OrderHistory;
import com.rkfoods.model.User;
import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;

@WebServlet("/OrderHistory")
public class OrderHistoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Get logged-in user
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            resp.sendRedirect("Login.jsp");
            return;
        }
        int userId = user.getUserId();

        // Get the cart and calculate the total amount
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            resp.sendRedirect("Cart.jsp");
            return;
        }
        double totalAmount = cart.calculateTotal();

        // Order status is "pending"
        String status = "delivered";

        // Create OrderHistory object
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId((Integer) session.getAttribute("orderId"));
        orderHistory.setUserId(userId);
        orderHistory.setTotalAmount(totalAmount);
        orderHistory.setStatus(status);

        // Save order history using the DAO
        OrderHistoryDao orderHistoryDao = new OrderHistoryDaoImpl();
        int result = orderHistoryDao.addOrderHistory(orderHistory);

        if (result > 0) {
            // Successfully placed the order, don't remove cart here
            req.setAttribute("orderHistory", orderHistory); // Optional: send order info to JSP
            resp.sendRedirect("OrderConfirmation.jsp");
        } else {
            // Failure to place the order
            resp.sendRedirect("OrderError.jsp");
        }
    }
}
