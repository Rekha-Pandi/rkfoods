package com.rkfoods.servlets;
import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkfoods.model.Cart;
import com.rkfoods.model.User;

@WebServlet("/OrderTableServlet")
public class OrderTableServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hi");
        
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            System.out.println("Cart is empty. Redirecting to cart page.");
            resp.sendRedirect("cart.jsp"); // Redirect to cart if empty
            return;
        }

        String paymentMode = req.getParameter("paymentMethod");
        int restaurantId = (int) session.getAttribute("restaurantId");
        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            System.out.println("User not logged in. Redirecting to login.");
            resp.sendRedirect("login.jsp"); // Redirect to login if not logged in
            return;
        }

        // Extract user and session details
        int userId = user.getUserId();
        double totalAmount = cart.calculateTotal();
        String status = "delivered";

        OrderTableDao orderdao = new OrderTableDaoImpl();
        int orderId = orderdao.addOrder(restaurantId, userId, totalAmount, status, paymentMode);

        if (orderId != 0) {
            System.out.println("Order successfully placed with ID: " + orderId);
            session.setAttribute("orderId", orderId);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/OrderItem");
            dispatcher.forward(req, resp);
        } else {
            System.out.println("Failed to place the order.");
            resp.sendRedirect("errorPage.jsp"); // Redirect to error page if order fails
        }
    }
}
