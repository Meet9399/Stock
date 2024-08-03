package com.project.stocks.services;

import java.util.List;

import com.project.stocks.dto.MySharesDTO;
import com.project.stocks.entities.MyShares;

public interface MySharesService {
	public List<MyShares> findAll();
	
	public List<MySharesDTO> findAllDTO();
	
	public MySharesDTO buy(int user_id,int company_id,int quantity);
	
	public double sell(int user_id,int company_id,int quantity);
}
