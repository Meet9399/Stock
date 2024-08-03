package com.project.stocks.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class MyShares {

	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Stocks stock;
	
	@Column(length=5,nullable=false)
	private int quantity;
	
	@Column(precision=10,nullable=false)
	private double buy_price;
	
	@Column(precision=10,nullable=false)
	private double plprice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date;

	public MyShares(User user, Stocks stock, int quantity, double buy_price, double plprice,
			LocalDateTime date) {
		super();
		this.user = user;
		this.stock = stock;
		this.quantity = quantity;
		this.buy_price = buy_price;
		this.plprice = plprice;
		this.date = date;
	}

	public MyShares() {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(double buy_price) {
		this.buy_price = buy_price;
	}

	public double getPlprice() {
		return plprice;
	}

	public void setPlprice(double plprice) {
		this.plprice = plprice;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MyShares [user=" + user + ", stock=" + stock + ", quantity=" + quantity
				+ ", buy_price=" + buy_price + ", plprice=" + plprice + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(buy_price, date, plprice, quantity, stock, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyShares other = (MyShares) obj;
		return Double.doubleToLongBits(buy_price) == Double.doubleToLongBits(other.buy_price)
				&& Objects.equals(date, other.date)
				&& Double.doubleToLongBits(plprice) == Double.doubleToLongBits(other.plprice)
				&& quantity == other.quantity && Objects.equals(stock, other.stock) && Objects.equals(user, other.user);
	}
	
	
}
