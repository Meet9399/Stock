package com.project.stocks.dao;

import java.util.List;

import com.project.stocks.entities.MyShares;

public interface MySharesDAO {
	public List<MyShares> findAll();
	
	public MyShares buyShares(int user_id,int company_id,int quantity);
	
	public double sellShares(int user_id,int company_id,int quantity);
}
