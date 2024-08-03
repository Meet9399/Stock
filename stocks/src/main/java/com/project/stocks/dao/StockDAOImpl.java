package com.project.stocks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.stocks.entities.MyShares;
import com.project.stocks.entities.Stocks;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StockDAOImpl implements StockDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StockDAOImpl(EntityManager entitymanager) {
		this.entityManager = entitymanager;
	}
	
	@Override
	public List<Stocks> findAll() {
		TypedQuery<Stocks> query = entityManager.createQuery("from Stocks",Stocks.class);
		return query.getResultList();
	}

	@Override
	public Stocks findByName(String company_name) {
		TypedQuery<Stocks> query = entityManager.createQuery("from Stocks where company_name=:name",Stocks.class);
		query.setParameter("name", company_name);		
		return query.getSingleResult();
	}

	@Override
	public Stocks save(Stocks stock) {
		entityManager.merge(stock);
		return stock;
	}

	@Override
	public void deleteByName(String company_name) {
		TypedQuery<Stocks> query = entityManager.createQuery("from Stocks where company_name=:name",Stocks.class);
		query.setParameter("name", company_name);
		Stocks stock = query.getSingleResult();
		entityManager.remove(stock);

	}

	@Override
	public double updatePrice(String company_name, double new_price) {
		TypedQuery<Stocks> query = entityManager.createQuery("from Stocks where company_name=:name",Stocks.class);
		query.setParameter("name", company_name);
		Stocks stock = query.getSingleResult();
		double updown = new_price - stock.getCurrent_stock_price();
		int id = stock.getCompany_id();
		stock.setCurrent_stock_price(new_price);
		entityManager.merge(stock);
		TypedQuery<MyShares> query1 = entityManager.createQuery("Select m from MyShares m where m.stock.company_id=:cid",MyShares.class);
		query1.setParameter("cid", id);
		List<MyShares> shares = query1.getResultList();
		double price;
		for(MyShares x:shares) {
			price = (x.getQuantity() * new_price) - x.getBuy_price();
			x.setPlprice(price);
			entityManager.merge(x);
		}
		return updown;
	}

}
