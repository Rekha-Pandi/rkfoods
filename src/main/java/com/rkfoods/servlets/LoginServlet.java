package com.rkfoods.servlets;

import java.io.IOException;
import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkfoods.model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	UserDao userDao=new UserDaoImpl();
	User user = userDao.getUser(email);

	if (user != null && user.getPassword().equals(password)) {
		HttpSession session=req.getSession();
	    session.setAttribute("loggedInUser", user);
	    resp.sendRedirect("GetAllRestaurants");
	} else {                                                                                                            
	    resp.sendRedirect("failure.jsp");  
	}
	
	
	
}
}

