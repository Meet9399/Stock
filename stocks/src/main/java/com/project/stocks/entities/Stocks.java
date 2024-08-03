package com.project.stocks.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stocks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10)
	private int company_id;
	@Column(length = 20,nullable = false, unique=true)
	private String company_name;
//	@Column(precision=6,scale=2,nullable = false)
	private double current_stock_price;
	
	public Stocks(int company_id, String company_name, double current_stock_price) {
		super();
		this.company_id = company_id;
		this.company_name = company_name;
		this.current_stock_price = current_stock_price;
	}

	public Stocks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public double getCurrent_stock_price() {
		return current_stock_price;
	}

	public void setCurrent_stock_price(double current_stock_price) {
		this.current_stock_price = current_stock_price;
	}

	@Override
	public String toString() {
		return "Stocks [company_id=" + company_id + ", company_name=" + company_name + ", current_stock_price="
				+ current_stock_price + "]";
	}
	
	
}
