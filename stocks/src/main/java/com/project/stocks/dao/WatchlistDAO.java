package com.project.stocks.dao;

import java.util.List;

import com.project.stocks.entities.Watchlist;

public interface WatchlistDAO {
	public List<Watchlist> findAll();
	
	public List<Watchlist> viewStocks(int user);
	
	public Watchlist add(int user_id,int company_id);
	
	public void remove(int user_id,int comapny_id);
}
