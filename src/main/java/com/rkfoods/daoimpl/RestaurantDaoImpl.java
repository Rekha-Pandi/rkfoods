package com.rkfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rkfoods.dao.RestaurantDao;
import com.rkfoods.dbUtils.DBUtils;
import com.rkfoods.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
    Connection con;
    private PreparedStatement pstmnt;
    private Statement stmnt;
    private ResultSet resultSet;
    ArrayList<Restaurant> restaurantList = new ArrayList<>();
    Restaurant restaurant;
    int status = 0;

    private static final String ADD_RESTAURANT = "insert into restaurant(restaurantName,deliveryTime, cuisineType, address, rating, isActive, adminId, imgPath) values(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select * from restaurant";
    private static final String SELECT_BY_ID = "select * from restaurant where restaurantId=?";
    private static final String UPDATE_BY_ID = "update restaurant set restaurantName=?, deliveryTime=?, cuisineType=?, address=?, rating=?, isActive=?, adminId=?, imgPath=? where restaurantId=?";
    private static final String DELETE_BY_ID = "delete from restaurant where restaurantId=?";

    public RestaurantDaoImpl() {
        try {
            con = DBUtils.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addRestaurant(Restaurant r) {
        try {
            pstmnt = con.prepareStatement(ADD_RESTAURANT);
            pstmnt.setString(1, r.getRestaurantName());
            pstmnt.setInt(2, r.getDeliveryTime());
            pstmnt.setString(3, r.getCuisineType());
            pstmnt.setString(4, r.getAddress());
            pstmnt.setDouble(5, r.getRating());
            pstmnt.setBoolean(6, r.isActive());
            pstmnt.setInt(7, r.getAdminId());
            pstmnt.setString(8, r.getImgPath());
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Restaurant> getAllRestaurants() {
        try {
            stmnt = con.createStatement();
            resultSet = stmnt.executeQuery(SELECT_ALL);
            restaurantList = extractRestaurantFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        try {
            pstmnt = con.prepareStatement(SELECT_BY_ID);
            pstmnt.setInt(1, restaurantId);
            resultSet = pstmnt.executeQuery();
            restaurantList = extractRestaurantFromResultSet(resultSet);
            restaurant = restaurantList.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public int updateRestaurant(Restaurant r) {
        try {
            pstmnt = con.prepareStatement(UPDATE_BY_ID);
            pstmnt.setString(1, r.getRestaurantName());
            pstmnt.setInt(2, r.getDeliveryTime());
            pstmnt.setString(3, r.getCuisineType());
            pstmnt.setString(4, r.getAddress());
            pstmnt.setDouble(5, r.getRating());
            pstmnt.setBoolean(6, r.isActive());
            pstmnt.setInt(7, r.getAdminId());
            pstmnt.setString(8, r.getImgPath());
            pstmnt.setInt(9, r.getRestaurantId());
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteRestaurant(int restaurantId) {
        try {
            pstmnt = con.prepareStatement(DELETE_BY_ID);
            pstmnt.setInt(1, restaurantId);
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    ArrayList<Restaurant> extractRestaurantFromResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                restaurantList.add(new Restaurant(
                        resultSet.getInt("restaurantId"),
                        resultSet.getString("restaurantName"),
                        resultSet.getInt("deliveryTime"),
                        resultSet.getString("cuisineType"),
                        resultSet.getString("address"),
                        resultSet.getDouble("rating"),
                        resultSet.getBoolean("isActive"),
                        resultSet.getInt("adminId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantList;
    }
}
