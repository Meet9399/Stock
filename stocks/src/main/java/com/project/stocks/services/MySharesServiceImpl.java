package com.project.stocks.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.stocks.dao.MySharesDAO;
import com.project.stocks.dto.MySharesDTO;
import com.project.stocks.entities.MyShares;

@Service
public class MySharesServiceImpl implements MySharesService {

	private MySharesDAO mysharesdao;
	
	@Autowired
	public MySharesServiceImpl(MySharesDAO mysharesdao) {
		this.mysharesdao = mysharesdao;
	}

	@Override
	public List<MyShares> findAll() {
		return mysharesdao.findAll();
	}

	@Override
	public List<MySharesDTO> findAllDTO() {
	    List<MyShares> mySharesList = findAll();
	    List<MySharesDTO> mySharesDTOList = new ArrayList<>();
	    for (MyShares myShares : mySharesList) {
	        MySharesDTO mySharesDTO = new MySharesDTO();
	        mySharesDTO.setUsername(myShares.getUser().getUsername());
	        mySharesDTO.setCompany_name(myShares.getStock().getCompany_name());
	        mySharesDTO.setQuantity(myShares.getQuantity());
	        mySharesDTO.setBuy_price(myShares.getBuy_price());
	        mySharesDTO.setPlprice(myShares.getPlprice());
	        mySharesDTO.setDate(myShares.getDate());
	        mySharesDTOList.add(mySharesDTO);
	    }
	    System.out.println(mySharesList);
	    return mySharesDTOList;
	}

	@Override
	@Transactional
	public MySharesDTO buy(int user_id, int company_id, int quantity) {
		
		MyShares share = mysharesdao.buyShares(user_id, company_id, quantity);
		MySharesDTO dto = new MySharesDTO(share.getUser().getUsername(),share.getStock().getCompany_name(),share.getQuantity(),share.getBuy_price(),share.getPlprice(),share.getDate());
		return dto;
	}

	@Override
	@Transactional
	public double sell(int user_id, int company_id, int quantity) {
		double check = mysharesdao.sellShares(user_id, company_id, quantity);
		return check;
	}

}
