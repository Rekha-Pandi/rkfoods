package com.rkfoods.daoimpl;

import java.sql.*;
import java.util.ArrayList;

import com.rkfoods.dao.OrderHistoryDao;
import com.rkfoods.dbUtils.DBUtils;
import com.rkfoods.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {

    private static final String ADD_ORDER_HISTORY = "INSERT INTO orderhistory(orderId, userId, totalAmount, status) VALUES(?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM orderhistory";
    private static final String SELECT_BY_ID = "SELECT * FROM orderhistory WHERE orderHistoryId = ?";
    private static final String SELECT_BY_USER_ID = "SELECT * FROM orderhistory WHERE userId = ?";
    private static final String SELECT_GUEST_ORDERS = "SELECT * FROM orderhistory WHERE userId IS NULL";

    // Add order history
    @Override
    public int addOrderHistory(OrderHistory oh) {
        int status = 0;
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(ADD_ORDER_HISTORY)) {

            pstmnt.setInt(1, oh.getOrderId());
            pstmnt.setInt(2, oh.getUserId());
            pstmnt.setDouble(3, oh.getTotalAmount());
            pstmnt.setString(4, oh.getStatus());
            status = pstmnt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return status;
    }

    // Get all orders (for admin or general view)
    @Override
    public ArrayList<OrderHistory> getAllOrderHistory() {
        ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(SELECT_ALL);
             ResultSet resultSet = pstmnt.executeQuery()) {

            orderHistoryList = extractOrderHistoryFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderHistoryList;
    }

    // Get order history for a specific orderHistoryId
    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        OrderHistory orderHistory = null;
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(SELECT_BY_ID)) {

            pstmnt.setInt(1, orderHistoryId);
            try (ResultSet resultSet = pstmnt.executeQuery()) {
                ArrayList<OrderHistory> orderHistoryList = extractOrderHistoryFromResultSet(resultSet);
                if (!orderHistoryList.isEmpty()) {
                    orderHistory = orderHistoryList.get(0);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderHistory;
    }

    // Get order history for a specific user (user logged in)
    @Override
    public ArrayList<OrderHistory> getOrderHistoryByUserId(int userId) {
        ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(SELECT_BY_USER_ID)) {

            pstmnt.setInt(1, userId);
            try (ResultSet resultSet = pstmnt.executeQuery()) {
                orderHistoryList = extractOrderHistoryFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderHistoryList; // Returns an empty list if no orders found
    }

    // Get guest orders (when the user is not logged in)
    @Override
    public ArrayList<OrderHistory> getGuestOrderHistory() {
        ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
        try (Connection con = DBUtils.myConnect();
             PreparedStatement pstmnt = con.prepareStatement(SELECT_GUEST_ORDERS);
             ResultSet resultSet = pstmnt.executeQuery()) {

            orderHistoryList = extractOrderHistoryFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderHistoryList; // Returns an empty list if no orders found
    }

    // Helper method to extract OrderHistory objects from ResultSet
    private ArrayList<OrderHistory> extractOrderHistoryFromResultSet(ResultSet resultSet) {
        ArrayList<OrderHistory> orderHistoryList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                orderHistoryList.add(new OrderHistory(
                    resultSet.getInt("orderHistoryId"),
                    resultSet.getInt("orderId"),
                    resultSet.getInt("userId"),
                    resultSet.getDate("orderDate"),
                    resultSet.getDouble("totalAmount"),
                    resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider logging the exception for production use
        }
        return orderHistoryList;
    }
}
