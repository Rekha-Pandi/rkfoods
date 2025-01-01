package com.rkfoods.model;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private int deliveryTime;
	private String cuisineType;
	private String address;
	private double rating;
	private boolean isActive;
	private int adminId;
	private String imgPath;
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String restaurantName, int deliveryTime, String cuisineType, String address,
			double rating, boolean isActive, int adminId) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.adminId = adminId;
		
	}
	public Restaurant(String restaurantName, int deliveryTime, String cuisineType, String address, double rating,
			boolean isActive, int adminId) {
		super();
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.adminId = adminId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", deliveryTime="
				+ deliveryTime + ", cuisineType=" + cuisineType + ", address=" + address + ", rating=" + rating
				+ ", isActive=" + isActive + ", adminId=" + adminId + ", imgPath=" + imgPath + "]";
	}
	
	

}
