package com.project.stocks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.stocks.entities.Watchlist;
import com.project.stocks.services.WatchlistService;

@RestController
@RequestMapping("/watch")
public class WatchlistController {
	
	@Autowired
	private WatchlistService watchlistService;
	
	@GetMapping("/watchlist")
	public List<Watchlist> findAll(){
		return this.watchlistService.findAll();
	}
	
	@GetMapping("/watchlist/{user}")
	public List<Watchlist> viewStocks(@PathVariable int user){
		return this.watchlistService.viewStocks(user);
	}
	
	@PostMapping("/add")
	public Watchlist add(@RequestParam("user_id") int userId, @RequestParam("company_id") int companyId) {
	    return this.watchlistService.add(userId, companyId);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<HttpStatus> remove(@RequestParam("user_id") int userId, @RequestParam("company_id") int companyId) {
		try{
			this.watchlistService.remove(userId, companyId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
}
