package com.project.stocks.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stocks.dto.UserDTO;
import com.project.stocks.entities.User;
import com.project.stocks.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserDTO> getUsers(){
		return this.userService.getUsersDTO();
	}
	
	@GetMapping("/users/{user_id}")
	public UserDTO getUser(@PathVariable int user_id){
		return this.userService.getUser(user_id);
	}
	
	@PostMapping("/user")
	public User addUpdateUser(@RequestBody User user) {
		return this.userService.addUpUser(user);
	}
	
//	@PutMapping("/user")
//	public User updateUser(@RequestBody User user) {
//		return this.userService.addUpUser(user);
//	}
	
	@DeleteMapping("/user/{user_id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable int user_id){ 
		try {
			this.userService.deleteUser(user_id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
