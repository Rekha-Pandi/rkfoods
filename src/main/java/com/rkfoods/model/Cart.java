package com.rkfoods.model;

import java.util.Map;
import java.util.HashMap;

public class Cart {
    private Map<Integer, CartItem> items = new HashMap<>();

    
    public Map<Integer, CartItem> getAllItems() {
        return items;
    }

    
    public void addItem(CartItem item) {
        items.put(item.getMenuId(), item);
    }

   
    public void removeItem(int menuId) {
        items.remove(menuId);
    }

   
    public void updateItemQuantity(int menuId, int quantity) {
        CartItem item = items.get(menuId);
        if (item != null) {
            item.setQuantity(quantity);  
            item.setSubTotal(item.getPrice() * quantity);  
        }
    }

   
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getSubTotal();  
        }
        return total;
    }
}
