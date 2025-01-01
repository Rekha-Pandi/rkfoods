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

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

    // Handles POST request to add items to the cart
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        // Retrieve the cart from the session, or create a new one if null
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);  // Store the new cart in the session
        }

        // Retrieve item details from the request parameters
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int menuId = Integer.parseInt(request.getParameter("menuId"));

        // Check if the item is already in the cart
        CartItem existingItem = cart.getAllItems().get(menuId);
        if (existingItem != null) {
            // If item exists, update the quantity
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            // If item doesn't exist, create a new CartItem
            CartItem cartItem = new CartItem(restaurantId, name, quantity, price);
            cartItem.setMenuId(menuId);  // Set the menuId for the CartItem
            cart.addItem(cartItem);  // Add the item to the cart
        }

        // Redirect to the cart page to display the updated cart
        response.sendRedirect("Cart.jsp");
    }
}
