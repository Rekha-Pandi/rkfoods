package com.rkfoods.servlets;

import com.rkfoods.model.Cart;
import com.rkfoods.model.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CartAction")
public class ActionCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // If the cart is null, initialize it
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");
        String menuIdStr = request.getParameter("menuId");
        int menuId = Integer.parseInt(menuIdStr);

        if ("remove".equals(action)) {
            // Remove the item from the cart
            cart.removeItem(menuId);
        } else if ("update".equals(action)) {
            // Update the quantity of the item in the cart
            String quantityStr = request.getParameter("quantity");
            int quantity = Integer.parseInt(quantityStr);
            cart.updateItemQuantity(menuId, quantity);
        }

        // Redirect to the Cart.jsp page to reflect the updated cart
        response.sendRedirect("Cart.jsp");
    }
}
