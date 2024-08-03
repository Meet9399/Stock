package com.project.stocks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.stocks.dto.MySharesDTO;
import com.project.stocks.services.MySharesService;

@RestController
@RequestMapping("/myshares")
public class MySharesController {
	
	private MySharesService myshareService;

	@Autowired
	public MySharesController(MySharesService myshareService) {
		this.myshareService = myshareService;
	}

	@GetMapping("/myshareslist")
	public List<MySharesDTO> findAll(){
		return this.myshareService.findAllDTO();
	}
	
	@PostMapping("/buy")
	public MySharesDTO buy(@RequestParam("user_id") int userId, @RequestParam("company_id") int companyId, @RequestParam("quantity") int quantity){
		return this.myshareService.buy(userId, companyId, quantity);
	}
	
	@PostMapping("/sell")
	public String sell(@RequestParam("user_id") int userId, @RequestParam("company_id") int companyId, @RequestParam("quantity") int quantity) {
		double check = this.myshareService.sell(userId, companyId, quantity);
		if(check == 0)
			return "Exception: Quantity Misplaced";
		else
			return "Sold: Profit = "+check;
	}
}
