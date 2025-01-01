
package com.rkfoods.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session to log out the user
        HttpSession session = request.getSession(false); // Get existing session, do not create a new one
        if (session != null) {
            session.invalidate(); // Destroy the session
        }
        // Redirect to the login or home page
        response.sendRedirect("login.jsp"); // Adjust to your login page
    }
}
