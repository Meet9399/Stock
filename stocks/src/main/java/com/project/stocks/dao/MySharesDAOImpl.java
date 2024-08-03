package com.project.stocks.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.stocks.entities.MyShares;
import com.project.stocks.entities.Stocks;
import com.project.stocks.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class MySharesDAOImpl implements MySharesDAO {

	private EntityManager entityManager;
	
	@Autowired
	public MySharesDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<MyShares> findAll() {
		TypedQuery<MyShares> query = entityManager.createQuery("from MyShares",MyShares.class);
		return query.getResultList();
	}

	@Override
	public MyShares buyShares(int user_id, int company_id, int quantity) {
		TypedQuery<User> query1 = entityManager.createQuery("from User where user_id =: uid",User.class);
		query1.setParameter("uid", user_id);
		User user = query1.getSingleResult();
		
		TypedQuery<Stocks> query2 = entityManager.createQuery("from Stocks where company_id =: cid",Stocks.class);
		query2.setParameter("cid", company_id);
		Stocks stock = query2.getSingleResult();
		LocalDateTime date = LocalDateTime.now();
		MyShares share = new MyShares(user,stock,quantity,stock.getCurrent_stock_price()*quantity,0,date);
		entityManager.persist(share);
		return share;
	}

	@Override
	public double sellShares(int user_id, int company_id, int quantity) {
		TypedQuery<MyShares> query = entityManager.createQuery("Select m from MyShares m where m.user.user_id=:uid and m.stock.company_id=:cid",MyShares.class);
		query.setParameter("uid", user_id);
		query.setParameter("cid", company_id);
		MyShares share = query.getSingleResult();
		int qty = share.getQuantity();
		double price = share.getStock().getCurrent_stock_price();
		double amount = 0;
		double profit = 0;
		if(qty < quantity)
			return 0;
		else if(share.getQuantity()==quantity){
			amount = price * quantity;
			profit = amount - share.getBuy_price();
			entityManager.remove(share);
			return profit;
		}
		else {	
			qty -= quantity;
			amount = price * quantity;
			profit = amount - ((share.getBuy_price()/share.getQuantity()) * quantity);
			share.setBuy_price(share.getBuy_price() - ((share.getBuy_price()/share.getQuantity()) * quantity));
			share.setQuantity(qty);
			entityManager.merge(share);
			return profit;
		}
	}

}
