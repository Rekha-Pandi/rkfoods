package com.rkfoods.model;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String menuName;
	private double price;
	private  String description;
	private boolean isAvailable;
	private String imgPath;
	public Menu() {
		super();
	}
	public Menu(int menuId, int restaurantId, String menuName, double price, String description, boolean isAvailable,
			String imgPath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	public Menu(int restaurantId, String menuName, double price, String description, boolean isAvailable,
			String imgPath) {
		super();
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
		this.imgPath = imgPath;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", menuName=" + menuName + ", price="
				+ price + ", description=" + description + ", isAvailable=" + isAvailable + ", imgPath=" + imgPath
				+ "]";
	}

}
