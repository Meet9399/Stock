package com.project.stocks.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stocks.dao.StockDAO;
import com.project.stocks.entities.Stocks;

import jakarta.transaction.Transactional;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockDAO stockdao;
		
	@Override
	public List<Stocks> getStocks() {
		return stockdao.findAll();
	}

	@Override
	public Stocks getStock(String company_name) {		
		return stockdao.findByName(company_name);		
	}

	@Override
	@Transactional
	public Stocks addUpStock(Stocks stock) {
		stockdao.save(stock);
		return stock;		
	}

	@Override
	@Transactional
	public void deleteStock(String company_name) {
		stockdao.deleteByName(company_name);
	}

	@Override
	@Transactional
	public double updatePrice(String company_name, double new_price) {
		return stockdao.updatePrice(company_name, new_price);
	}

}
