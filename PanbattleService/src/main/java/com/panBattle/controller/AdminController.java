package com.panBattle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panBattle.modal.Admin;
import com.panBattle.modal.Game;
import com.panBattle.service.AdminService;
import com.panBattle.service.CommonServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	@Autowired
	CommonServices commonServices;
	
	@PostMapping("/add")
	public Admin add(@RequestBody Admin admin)
	{
		return adminService.save(admin);
	}
	@PostMapping("/addgame")
	public Game addGame(@RequestBody Game game)
	{
		return adminService.addGame(game);
		
	}
	@DeleteMapping("/delete-game/{id}")
	public void deleteGame(@PathVariable int id)
	{
		adminService.deleteGamne(id);
	}

}
