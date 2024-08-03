package com.project.stocks.dto;

public class UserDTO {
	private int user_id;
	private String username;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int user_id, String username) {
		super();
		this.user_id = user_id;
		this.username = username;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", username=" + username + "]";
	}
	
	
}
