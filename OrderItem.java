package com.rkfoods.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkfoods.model.Cart;
import com.rkfoods.model.CartItem;
import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;

@WebServlet("/OrderItem")
public class OrderItem extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Integer orderId = (Integer) session.getAttribute("orderId");

        if (cart == null || orderId == null) {
            req.setAttribute("errorMessage", "Cart or Order information is missing. Please try again.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Cart.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        boolean allItemsInsertedSuccessfully = true;

        // Process each cart item
        for (Map.Entry<Integer, CartItem> entry : cart.getAllItems().entrySet()) {
            CartItem item = entry.getValue();
            int menuId = item.getMenuId();
            double subTotal = item.getSubTotal();
            int quantity = item.getQuantity();

            int status = orderItemDao.addOrderItem(orderId, menuId, quantity, subTotal);
            if (status == 0) {
                allItemsInsertedSuccessfully = false;
                System.err.println("Failed to insert item with menuId: " + menuId);
            } else {
                System.out.println("Successfully inserted item with menuId: " + menuId);
            }
        }

        if (allItemsInsertedSuccessfully) {
            // Don't clear the cart here; keep it in the session
            System.out.println("All items processed successfully.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/OrderHistory");
            dispatcher.forward(req, resp);  // Forward to OrderHistory servlet
        } else {
            req.setAttribute("errorMessage", "Some items could not be processed. Please try again.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Cart.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
