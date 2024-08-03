package com.project.stocks.services;

import java.util.List;
import com.project.stocks.entities.Stocks;

public interface StockService {

	public List<Stocks> getStocks();
	
	public Stocks getStock(String company_name);
	
	public Stocks addUpStock(Stocks stock);
	
//	public Stocks updateStock(Stocks stock);
	
	public void deleteStock(String company_name);
	
	public double updatePrice(String company_name, double new_price);
}
