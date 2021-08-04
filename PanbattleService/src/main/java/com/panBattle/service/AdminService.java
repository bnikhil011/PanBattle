package com.panBattle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panBattle.dao.AdminDao;
import com.panBattle.dao.GameDao;
import com.panBattle.modal.Admin;
import com.panBattle.modal.Game;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private GameDao gameDao;
	
	public Admin save(Admin admin)
	{
		return adminDao.save(admin);
	}
	public Admin update(Admin admin)
	{
		return adminDao.save(admin);
	}
	
	public boolean delete(long id)
	{
		Admin admin = new Admin();
		admin.setId(id);
		adminDao.delete(admin);
		return true;
	}
	
	public Game addGame(Game game)
	{
		return gameDao.save(game);
	}
	
	
}
