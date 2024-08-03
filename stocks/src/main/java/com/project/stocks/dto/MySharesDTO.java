package com.project.stocks.dto;

import java.time.LocalDateTime;

public class MySharesDTO {
	private String username;
	private String company_name;
	private int quantity;
	private double buy_price;
	private double plprice;
	private LocalDateTime date;
	public MySharesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MySharesDTO(String username, String company_name, int quantity, double buy_price, double plprice,
			LocalDateTime date) {
		super();
		this.username = username;
		this.company_name = company_name;
		this.quantity = quantity;
		this.buy_price = buy_price;
		this.plprice = plprice;
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(double buy_price) {
		this.buy_price = buy_price;
	}
	public double getPlprice() {
		return plprice;
	}
	public void setPlprice(double plprice) {
		this.plprice = plprice;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MySharesDTO [username=" + username + ", company_name=" + company_name + ", quantity=" + quantity
				+ ", buy_price=" + buy_price + ", plprice=" + plprice + ", date=" + date + "]";
	}
	
}
