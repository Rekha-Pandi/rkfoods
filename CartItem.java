package com.rkfoods.model;

public class CartItem {
    private int menuId;
    private int restaurantId;
    private String name;
    private int quantity;
    private double price;
    private double subTotal;

   
    public CartItem(int restaurantId, String name, int quantity, double price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = quantity * price;  
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subTotal = quantity * price;  // Recalculate subtotal when quantity changes
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.subTotal = quantity * price;  // Recalculate subtotal when price changes
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;  // Setter for subTotal, though it's mostly calculated
    }
}
