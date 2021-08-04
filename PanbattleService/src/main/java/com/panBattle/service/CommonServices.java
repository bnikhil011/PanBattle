package com.panBattle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panBattle.dao.AdminDao;
import com.panBattle.dao.GameDao;
import com.panBattle.dao.UserDao;
import com.panBattle.modal.Admin;
import com.panBattle.modal.Game;
import com.panBattle.modal.User;

@Service
public class CommonServices {
	@Autowired
	private GameDao gameDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AdminDao adminDao;
	
	public List<User> getAllUsers()
	{
		return userDao.findAll();
	}
	public List<Game> getAllGame()
	{
		return gameDao.findAll();
	}
	public List<Admin> getAllAdmin()
	{
		return adminDao.findAll();
	}
	
}
