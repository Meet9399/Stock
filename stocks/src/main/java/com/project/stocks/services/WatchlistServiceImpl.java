package com.project.stocks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stocks.dao.WatchlistDAO;
import com.project.stocks.entities.Watchlist;

import jakarta.transaction.Transactional;

@Service
public class WatchlistServiceImpl implements WatchlistService {
	
	@Autowired
	private WatchlistDAO watchlistdao;
	
	@Override
	public List<Watchlist> findAll() {
		return watchlistdao.findAll();
	}

	@Override
	public List<Watchlist> viewStocks(int user) {
		return watchlistdao.viewStocks(user);
	}

	@Override
	@Transactional
	public Watchlist add(int user_id,int company_id) {
		return watchlistdao.add(user_id,company_id);
	}

	@Override
	@Transactional
	public void remove(int user_id,int company_id) {
		watchlistdao.remove(user_id,company_id);
	}

}
