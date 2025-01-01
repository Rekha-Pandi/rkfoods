package com.rkfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rkfoods.dao.MenuDao;
import com.rkfoods.dbUtils.DBUtils;
import com.rkfoods.model.Menu;

public class MenuDaoImpl implements MenuDao {
    Connection con;
    private PreparedStatement pstmnt;
    private Statement stmnt;
    private ResultSet resultSet;
    ArrayList<Menu> menuList = new ArrayList<Menu>();
    Menu menu;
    int status = 0;
    
    private static final String ADD_MENU = "insert into menu(restaurantId, menuName, price, description, isAvailable, imgPath) values(?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "select * from menu";
    private static final String SELECT_ON_ID = "select * from menu where menuId=?";
    private static final String UPDATE_ON_ID = "update menu set restaurantId=?, menuName=?, price=?, description=?, isAvailable=?, imgPath=? where menuId=?";
    private static final String DELETE_ON_ID = "delete from menu where menuId=?";
    private static final String SELECT_BY_RESTAURANT_ID = "select * from menu where restaurantId=?";  // Corrected query for restaurant-based filtering

    public MenuDaoImpl() {
        try {
            con = DBUtils.myConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addMenu(Menu m) {
        try {
            pstmnt = con.prepareStatement(ADD_MENU);
            pstmnt.setInt(1, m.getRestaurantId());
            pstmnt.setString(2, m.getMenuName());
            pstmnt.setDouble(3, m.getPrice());
            pstmnt.setString(4, m.getDescription());
            pstmnt.setBoolean(5, m.isAvailable());
            pstmnt.setString(6, m.getImgPath());
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Menu> getMenus() {
        try {
            stmnt = con.createStatement();
            resultSet = stmnt.executeQuery(SELECT_ALL);
            menuList = extractMenuFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    @Override
    public Menu getMenu(int menuId) {
        try {
            pstmnt = con.prepareStatement(SELECT_ON_ID);
            pstmnt.setInt(1, menuId);
            resultSet = pstmnt.executeQuery();
            menuList = extractMenuFromResultSet(resultSet);
            menu = menuList.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

    @Override
    public int updateMenu(Menu m) {
        try {
            pstmnt = con.prepareStatement(UPDATE_ON_ID);
            pstmnt.setInt(1, m.getRestaurantId());
            pstmnt.setString(2, m.getMenuName());
            pstmnt.setDouble(3, m.getPrice());
            pstmnt.setString(4, m.getDescription());
            pstmnt.setBoolean(5, m.isAvailable());
            pstmnt.setString(6, m.getImgPath());
            pstmnt.setInt(7, m.getMenuId());
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int deleteMenu(int menuId) {
        try {
            pstmnt = con.prepareStatement(DELETE_ON_ID);
            pstmnt.setInt(1, menuId);
            status = pstmnt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<Menu> getMenuByRestaurantId(int restaurantId) {
        try {
            pstmnt = con.prepareStatement(SELECT_BY_RESTAURANT_ID);  // Corrected to fetch menus for specific restaurantId
            pstmnt.setInt(1, restaurantId);
            resultSet = pstmnt.executeQuery();
            menuList = extractMenuFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    // Helper method to extract menu data from ResultSet
    private ArrayList<Menu> extractMenuFromResultSet(ResultSet resultSet) {
        ArrayList<Menu> menuList = new ArrayList<Menu>();
        try {
            while (resultSet.next()) {
                menuList.add(new Menu(resultSet.getInt("menuId"),
                        resultSet.getInt("restaurantId"),
                        resultSet.getString("menuName"),
                        resultSet.getDouble("price"),
                        resultSet.getString("description"),
                        resultSet.getBoolean("isAvailable"),
                        resultSet.getString("imgPath")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
