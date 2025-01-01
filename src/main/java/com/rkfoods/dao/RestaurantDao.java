package com.rkfoods.dao;

import java.util.ArrayList;

import com.rkfoods.model.Restaurant;


public interface RestaurantDao {
	
	int addRestaurant(Restaurant r);
	ArrayList<Restaurant> getAllRestaurants();
	Restaurant getRestaurant(int restaurantId);
	int updateRestaurant(Restaurant r);
	int deleteRestaurant(int restaurantId);

}
