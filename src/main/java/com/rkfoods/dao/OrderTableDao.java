package com.rkfoods.dao;

import java.util.ArrayList;

import com.rkfoods.model.OrderTable;


public interface OrderTableDao {
	int addOrder(int restaurantId,int userId,double totalAmount,String status,String paymentMode);
	ArrayList<OrderTable> getAllOrders();
	OrderTable getOrders(int orderId);
	
}
