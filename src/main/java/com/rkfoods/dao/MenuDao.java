package com.rkfoods.dao;

import java.util.ArrayList;

import com.rkfoods.model.Menu;


public interface MenuDao {
	int addMenu(Menu m);
	ArrayList<Menu> getMenus();
	Menu getMenu(int menuId);
	int updateMenu(Menu m);
	int deleteMenu(int menuId);
	ArrayList<Menu> getMenuByRestaurantId(int restaurantId);
}
