package com.rkfoods.daoimpl;

import com.rkfoods.dao.OrderTableDao;
import com.rkfoods.dbUtils.DBUtils;
import com.rkfoods.model.OrderTable;

import java.sql.*;
import java.util.ArrayList;

public class OrderTableDaoImpl implements OrderTableDao {
    private Connection con;
    private PreparedStatement pstmnt;
    private Statement stmnt;
    private ResultSet resultSet;

    private static final String ADD_ORDER = "insert into ordertable(restaurantId,userId,totalAmount,status,paymentMode) values(?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from ordertable";
    private static final String SELECT_BY_ID = "select * from ordertable where orderId=?";

    public OrderTableDaoImpl() {
        try {
            con = DBUtils.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<OrderTable> getAllOrders() {
        ArrayList<OrderTable> orderTableList = new ArrayList<>();
        try (Statement stmnt = con.createStatement();
             ResultSet resultSet = stmnt.executeQuery(SELECT_ALL)) {
            orderTableList = extractOrderTableFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderTableList;
    }

    @Override
    public OrderTable getOrders(int orderId) {
        OrderTable orderTable = null;
        try (PreparedStatement pstmnt = con.prepareStatement(SELECT_BY_ID)) {
            pstmnt.setInt(1, orderId);
            try (ResultSet resultSet = pstmnt.executeQuery()) {
                ArrayList<OrderTable> orderTableList = extractOrderTableFromResultSet(resultSet);
                if (!orderTableList.isEmpty()) {
                    orderTable = orderTableList.get(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderTable;
    }

    private ArrayList<OrderTable> extractOrderTableFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<OrderTable> orderTableList = new ArrayList<>();
        while (resultSet.next()) {
            orderTableList.add(new OrderTable(
                    resultSet.getInt("restaurantId"),
                    resultSet.getInt("userId"),
                    resultSet.getDouble("totalAmount"),
                    resultSet.getString("status"),
                    resultSet.getString("paymentMode")
            ));
        }
        return orderTableList;
    }

    @Override
    public int addOrder(int restaurantId, int userId, double totalAmount, String status, String paymentMode) {
        int generatedOrderId = 0;
        try (PreparedStatement pstmnt = con.prepareStatement(ADD_ORDER, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmnt.setInt(1, restaurantId);
            pstmnt.setInt(2, userId);
            pstmnt.setDouble(3, totalAmount);
            pstmnt.setString(4, status);
            pstmnt.setString(5, paymentMode);

            int status1 = pstmnt.executeUpdate();

            if (status1 > 0) {
                try (ResultSet generatedKeys = pstmnt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedOrderId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedOrderId;
    }
}
