package com.rkfoods.servlets;

import com.rkfoods.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CartInsertServlet")
public class CartInsert extends HttpServlet {

    // Handles GET request for cart initialization
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Check if the cart already exists in session
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            // If no cart exists, create a new one
            cart = new Cart();
            session.setAttribute("cart", cart);  // Store the new cart in the session
        }

        // Forward the request to the page where the cart can be displayed
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }
}
