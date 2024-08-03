package com.project.stocks.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.stocks.entities.Stocks;
import com.project.stocks.entities.User;
import com.project.stocks.entities.Watchlist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class WatchlistDAOImpl implements WatchlistDAO {

	private EntityManager entityManager;
	
	@Autowired
	public WatchlistDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Watchlist> findAll() {
		TypedQuery<Watchlist> query = entityManager.createQuery("from Watchlist",Watchlist.class);
		return query.getResultList();
	}

	@Override
	public List<Watchlist> viewStocks(int userId) {
	    TypedQuery<Watchlist> query = entityManager.createQuery("SELECT w FROM Watchlist w JOIN FETCH w.user WHERE w.user.user_id = :userId", Watchlist.class);
	    query.setParameter("userId", userId);
	    return query.getResultList();
	}


	@Override
	public Watchlist add(int user_id,int company_id) {
		TypedQuery<User> query1 = entityManager.createQuery("from User where user_id = :userId", User.class);
		query1.setParameter("userId", user_id);
		User user = query1.getSingleResult();
		TypedQuery<Stocks> query2 = entityManager.createQuery("from Stocks where company_id = :stockId", Stocks.class);
		query2.setParameter("stockId", company_id);
		Stocks stock = query2.getSingleResult();
		
		Watchlist item = new Watchlist(user,stock);
		entityManager.merge(item);
		return item;
	}

	@Override
	public void remove(int user_id,int company_id) {
		TypedQuery<Watchlist> query = entityManager.createQuery("Select w from Watchlist w where w.user.user_id =:userId AND w.stock.company_id=:companyId", Watchlist.class);
		query.setParameter("userId",user_id);
		query.setParameter("companyId",company_id);
		Watchlist item = query.getSingleResult();
		entityManager.remove(item);		
	}

}
