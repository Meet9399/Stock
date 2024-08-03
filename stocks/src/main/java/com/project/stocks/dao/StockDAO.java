package com.project.stocks.dao;

import java.util.List;

import com.project.stocks.entities.Stocks;

public interface StockDAO{
	
	public List<Stocks> findAll();
	
	public Stocks findByName(String company_name);
	
	public Stocks save(Stocks stock);
	
	public void deleteByName(String company_name);
	
	public double updatePrice(String company_name,double new_price); 
}
