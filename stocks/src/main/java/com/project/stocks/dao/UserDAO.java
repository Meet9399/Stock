package com.project.stocks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.stocks.entities.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}
