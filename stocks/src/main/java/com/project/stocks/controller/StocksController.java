package com.project.stocks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.stocks.entities.Stocks;
import com.project.stocks.services.StockService;

@RestController
@RequestMapping("/stock")
public class StocksController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/stocks")
	public List<Stocks> getStocks(){
		
		return this.stockService.getStocks();
	}
	
	@GetMapping("/stocks/{company_name}")
	public Stocks getStock(@PathVariable String company_name) {
		
		return this.stockService.getStock(company_name);
	}
	
	@PostMapping("/stocks")
	public Stocks addStock(@RequestBody Stocks stock) {
		stock.setCompany_id(0);
		return this.stockService.addUpStock(stock);
	}
	
	@PutMapping("/stocks")
	public Stocks updateStock(@RequestBody Stocks stock) {
		return this.stockService.addUpStock(stock);
	}
	
	@DeleteMapping("/stocks/{company_name}")
	public ResponseEntity<HttpStatus> deleteStock(@PathVariable String company_name){
		try {
			this.stockService.deleteStock(company_name);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/change")
	public String updatePrice(@RequestParam("company_name") String company_name,@RequestParam("price") double price) {
		return "Profit/Loss = " + this.stockService.updatePrice(company_name, price);
	}
}
