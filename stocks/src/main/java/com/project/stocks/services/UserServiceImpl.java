package com.project.stocks.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stocks.dao.UserDAO;
import com.project.stocks.dto.UserDTO;
import com.project.stocks.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userdao;
	
	@Override
	public List<User> getUsers() {
		
		return userdao.findAll();
	}

	@Override
	public List<UserDTO> getUsersDTO() {
		List<User> userlist = getUsers();
		List<UserDTO> dtolist = new ArrayList<>();
		for(User x: userlist) {
			UserDTO userdto = new UserDTO();
			userdto.setUser_id(x.getUser_id());
			userdto.setUsername(x.getUsername());
			dtolist.add(userdto);
		}
		return dtolist;
	}

	@Override
	public UserDTO getUser(int user_id) {
		Optional<User> user = userdao.findById(user_id);
		UserDTO userdto = new UserDTO();
		userdto.setUser_id(user.get().getUser_id());
		userdto.setUsername(user.get().getUsername());
		return userdto;
	}

	@Override
	public User addUpUser(User user) {
	
		userdao.save(user);
		return user;
	}

	@Override
	public void deleteUser(int user_id) {
	
		userdao.deleteById(user_id);
	}

}
