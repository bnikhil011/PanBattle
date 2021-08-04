package com.panBattle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panBattle.modal.Game;
import com.panBattle.modal.User;
import com.panBattle.service.CommonServices;

@RestController
@RequestMapping("/services")
public class MainServiceController {
	@Autowired
	private CommonServices commonService; 
	
	@GetMapping("/allusers")
	public List<User> getallUsers()
	{
		return commonService.getAllUsers();
	}
	@GetMapping("/allgames")
	public List<Game>getAllGames()
	{
		return commonService.getAllGame();
	}
	

}
