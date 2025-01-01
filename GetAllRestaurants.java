package com.rkfoods.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkfoods.model.Restaurant;

/**
 * Servlet implementation class GetAllRestaurants
 */
@WebServlet("/GetAllRestaurants")
public class GetAllRestaurants extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RestaurantDao restaurant1=new RestaurantDaoImpl();
		ArrayList<Restaurant> restaurantList=restaurant1.getAllRestaurants();
		HttpSession session=req.getSession();
		session.setAttribute("restaurantList", restaurantList);
		resp.sendRedirect("home.jsp");
		
	}
	

}
