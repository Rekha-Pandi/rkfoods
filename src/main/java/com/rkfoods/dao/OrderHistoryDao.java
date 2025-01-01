package com.rkfoods.dao;

import java.util.ArrayList;

import com.rkfoods.model.OrderHistory;

public interface OrderHistoryDao {
    int addOrderHistory(OrderHistory oh);
    ArrayList<OrderHistory> getAllOrderHistory();
    OrderHistory getOrderHistory(int orderHistoryId);
    
    // Methods for fetching orders based on userId and guest orders
    ArrayList<OrderHistory> getOrderHistoryByUserId(int userId); // For logged-in users
    ArrayList<OrderHistory> getGuestOrderHistory(); // For guests (users who are not logged in)
}
