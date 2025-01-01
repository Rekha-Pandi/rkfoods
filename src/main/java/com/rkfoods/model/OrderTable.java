package com.rkfoods.model;

import java.util.Date;

public class OrderTable {
	private int orderId;
	private int restaurantId;
	private int userId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	private  String paymentMode;
	public OrderTable() {
		super();
	}
	
	public OrderTable(int orderId, int restaurantId, int userId, Date orderDate, double totalAmount, String status,
			String paymentMode) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
    
	public OrderTable(int restaurantId, int userId, double totalAmount, String status,
			String paymentMode) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "OrderTable [orderId=" + orderId + ", restaurantId=" + restaurantId + ", userId=" + userId
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode="
				+ paymentMode + "]";
	}
	


}
