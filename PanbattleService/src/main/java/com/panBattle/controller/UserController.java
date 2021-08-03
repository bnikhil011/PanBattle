package com.panBattle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.panBattle.modal.User;
import com.panBattle.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<User>addUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<User>updateUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.save(user),HttpStatus.ACCEPTED);
	}

}
