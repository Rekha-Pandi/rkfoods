package com.rkfoods.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rkfoods.dao.UserDao;
import com.rkfoods.dbUtils.DBUtils;
import com.rkfoods.model.User;

public class UserDaoImpl implements UserDao {
	Connection con;
	private PreparedStatement pstmnt;
	private Statement stmnt;
	private ResultSet resultSet;
	ArrayList <User>userList=new ArrayList<User>();
	User user;
	int status=0;
	private static final String Add_User="insert into user(UserName,email,phoneNumber,password,address)values(?,?,?,?,?)";
	private static final String SELECT_ALL="select *from user";
	private static final String SELECT_ON_EMAIL ="select *from user where email=?";
	private static final String UPDATE_ON_EMAIL="update user set userName=?,phoneNumber=?,password=?,address=? where email=?";
	private static final String DELETE_ON_EMAIL="delete from user where userId=?";
	
	public UserDaoImpl(){
		try {
		con=DBUtils.myConnect();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int addUser(User u) {
		
		
	    try {
			pstmnt=con.prepareStatement(Add_User);
			pstmnt.setString(1, u.getUserName());
			pstmnt.setString(2, u.getEmail());
			pstmnt.setString(3, u.getPhoneNumber());
			pstmnt.setString(4, u.getPassword());
			pstmnt.setString(5, u.getAddress());
			 status=pstmnt.executeUpdate();
			
		} 
	    catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		
		try {
			stmnt=con.createStatement();
			resultSet=stmnt.executeQuery(SELECT_ALL);
			userList=extractUserFromResultSet(resultSet);
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
		
	}

	@Override
	public User getUser(String email) {
		User user=null;
	    try {
	        pstmnt = con.prepareStatement(SELECT_ON_EMAIL);
	        pstmnt.setString(1, email);
	        resultSet = pstmnt.executeQuery();
	        
          if(resultSet.next()) {
        	user=extractuserFromResultSet(resultSet);  
        	  
        	  
          }
          
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return user;
	}


	@Override
	public int updateUser(User u) {
		try {
			pstmnt=con.prepareStatement(UPDATE_ON_EMAIL);
			pstmnt.setString(1, u.getUserName());
			pstmnt.setString(2, u.getPhoneNumber());
			pstmnt.setString(3, u.getPassword());
			pstmnt.setString(4, u.getAddress());
			pstmnt.setString(5, u.getEmail());
			
			
			status=pstmnt.executeUpdate();
			
			
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
		
		
		
	}

	@Override
	public int deleteUser(String email) {
		
		
		try {
			pstmnt=con.prepareStatement(DELETE_ON_EMAIL);
			pstmnt.setString(1, email);
			status=pstmnt.executeUpdate();	
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
		
	}
	private User extractuserFromResultSet(ResultSet resultSet) {
		User user=new User();
		try {
			user.setUserId(resultSet.getInt("userId"));
			user.setUserName(resultSet.getString("userName"));
			user.setEmail(resultSet.getString("email"));
			user.setPhoneNumber(resultSet.getString("phoneNumber"));
			user.setPassword(resultSet.getString("password"));
			user.setAddress(resultSet.getString("address"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
		
	}
	ArrayList<User> extractUserFromResultSet(ResultSet resultSet) {
	   
	    try {
	        while (resultSet.next()) {
	            userList.add(new User(
	                resultSet.getInt("userId"),       // Integer for userId
	                resultSet.getString("userName"), // String for userName
	                resultSet.getString("email"),    // String for email
	                resultSet.getString("phoneNumber"), // String for phoneNumber
	                resultSet.getString("password"),    // String for password
	                resultSet.getString("address")      // String for address
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return userList;
	}

		
}

