package com.project.stocks.entities;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Watchlist {
	@Override
	public int hashCode() {
		return Objects.hash(stock, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Watchlist other = (Watchlist) obj;
		return Objects.equals(stock, other.stock) && Objects.equals(user, other.user);
	}
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Stocks stock;
	
	public Watchlist(User user, Stocks stock) {
		super();
		this.user = user;
		this.stock = stock;
	}
	public Watchlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Stocks getStock() {
		return stock;
	}
	public void setStock(Stocks stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Watchlist [user=" + user + ", stock=" + stock + "]";
	}
	
	
}
