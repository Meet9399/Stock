package com.project.stocks.services;
import java.util.List;
import com.project.stocks.dto.UserDTO;
import com.project.stocks.entities.User;

public interface UserService {
	public List<User> getUsers();
	
	public List<UserDTO> getUsersDTO();
	
	public UserDTO getUser(int user_id);
	
	public User addUpUser(User user);
	
	public void deleteUser(int user_id);
	
}
