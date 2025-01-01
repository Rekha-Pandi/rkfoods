package com.rkfoods.servlets;

import com.rkfoods.model.User;
import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Retrieve form data
	    String userName = request.getParameter("userName");
	    String email = request.getParameter("email");
	    String phoneNumber = request.getParameter("phoneNumber");
	    String password = request.getParameter("password");
	    String address = request.getParameter("address");

	    // Create User object
	    User user = new User();
	    user.setUserName(userName);
	    user.setEmail(email);
	    user.setPhoneNumber(phoneNumber);
	    user.setPassword(password);
	    user.setAddress(address);

	    // Call addUser() and get the result (int)
	    UserDao userDao = new UserDaoImpl();
	    int result = userDao.addUser(user);  // Assuming it returns 1 for success, 0 for failure

	    // Check the result and redirect accordingly
	    if (result == 1) {  // If the insert was successful
	        response.sendRedirect("RegistrationSucess.jsp");  // Redirect to login or other success page
	    } else {
	        response.sendRedirect("errorPage.jsp");  // Handle error case
	    }
	}

}
