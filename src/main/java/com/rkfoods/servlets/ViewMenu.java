package com.rkfoods.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.rkfoods.dao.*;
import com.rkfoods.daoimpl.*;
import com.rkfoods.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewMenu
 */
@WebServlet("/ViewMenu")
public class ViewMenu extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
	     MenuDao menuDao=new MenuDaoImpl();
	     ArrayList<Menu> menuList=menuDao.getMenuByRestaurantId(restaurantId);
	     HttpSession session=req.getSession();
			session.setAttribute("menuList", menuList);
			session.setAttribute("restaurantId", restaurantId);
			resp.sendRedirect("menu.jsp");
	}
}
