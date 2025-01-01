package com.rkfoods.daoimpl;

import java.sql.*;
import java.util.ArrayList;

import com.rkfoods.dao.OrderItemDao;
import com.rkfoods.dbUtils.DBUtils;
import com.rkfoods.model.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao {
    private static final String ADD_ORDER_ITEM = "INSERT INTO orderitem(orderId, menuId, quantity, subTotal) VALUES(?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM orderitem";
    private static final String SELECT_BY_ID = "SELECT * FROM orderitem WHERE orderItemId = ?";
    
    // Method to add an order item to the database
    @Override
    public int addOrderItem(int orderId,int menuId,int quantity,double subTotal) {
        int status = 0;
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(ADD_ORDER_ITEM)) {
            pstmnt.setInt(1, orderId);
            pstmnt.setInt(2, menuId);
            pstmnt.setInt(3, quantity);
            pstmnt.setDouble(4, subTotal);
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return status;
    }

    // Method to get all order items from the database
    @Override
    public ArrayList<OrderItem> getAllOrderItems() {
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(SELECT_ALL);
             ResultSet resultSet = pstmnt.executeQuery()) {
            orderItemList = extractOrderItemsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderItemList;
    }

    // Method to get an order item by its ID
    @Override
    public OrderItem getOrderItem(int orderItemId) {
        OrderItem orderItem = null;
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(SELECT_BY_ID)) {
            pstmnt.setInt(1, orderItemId);
            try (ResultSet resultSet = pstmnt.executeQuery()) {
                ArrayList<OrderItem> orderItemList = extractOrderItemsFromResultSet(resultSet);
                if (!orderItemList.isEmpty()) {
                    orderItem = orderItemList.get(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderItem;
    }

    // Helper method to extract OrderItems from ResultSet
    private ArrayList<OrderItem> extractOrderItemsFromResultSet(ResultSet resultSet) {
        ArrayList<OrderItem> orderItemList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                orderItemList.add(new OrderItem(
                        resultSet.getInt("orderItemId"),
                        resultSet.getInt("orderId"),
                        resultSet.getInt("menuId"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("subTotal")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderItemList;
    }
}
