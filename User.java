package com.rkfoods.model;

public class User {
	private int userId;
	private String userName;
	private String email;
	private String phoneNumber;
	private String password;
	private String  address;
	
	public User() {
		super();
	}
	public User(int userId, String userName, String email, String phoneNumber, String password, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
	}
	
	public User(String userName, String email, String phoneNumber, String password, String address) {
		super();
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", address=" + address + "]";
	}
	

}
