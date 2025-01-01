package com.rkfoods.dao;

import java.util.ArrayList;

import com.rkfoods.model.OrderItem;


public interface OrderItemDao {
	int addOrderItem(int orderId,int menuId,int quantity,double subTotal);
	ArrayList<OrderItem> getAllOrderItems();
	OrderItem getOrderItem(int orderItemId);

}
