package com.panBattle.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panBattle.dao.GameDao;
import com.panBattle.dao.UserDao;
import com.panBattle.exceptions.ModalNullException;
import com.panBattle.exceptions.UserException;
import com.panBattle.modal.Game;
import com.panBattle.modal.User;
@Service
public class UserService  {
	@Autowired
	UserDao userDao;
	@Autowired
	GameDao gameDao;
	
	public User findUser(User user)
	{
		Optional<User> usr = userDao.findUser(user.getName(), user.getPassword());
		if(usr.isEmpty())
			throw new UserException("User is not avilable");
		else
			return usr.get();
	}
	public User save(User user) {
		
		if(hasRequiredValues(user) && isValidNewUser(user))
		{
			user = EncryptPassword(user);
			return userDao.save(user);
		}
		System.out.print(hasRequiredValues(user)+" "+isValidNewUser(user));
		 
		return null;
		
	}

	
	public User update(User user) {
		
		return userDao.save(user);
	}

	
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(id);
		userDao.delete(user);
		return true;
	}
	
	public boolean hasRequiredValues(User user)
	{
		if((user.getEmailid()==null || user.getEmailid().isEmpty()) 
		|| (user.getName()== null || user.getName().isEmpty())
		|| (user.getPassword()==null || user.getPassword().isEmpty()))
			throw new ModalNullException("Some required data is missing in User payload send");
			
		else
			return true;
	}
	
	public boolean isValidNewUser(User user)
	{
	
		System.out.println(user);
		if(user.getCoins()==0 && user.getEmailid().contains("@")
		&& user.getGames()== null && user.getScore()==0)
		{	if(isnameAvilable(user) == true)
			System.out.println("isnameAvilable is true");
				return true;
		}
		
		throw new UserException("Data Sent is not correct");	
		
	}
	
	public boolean isnameAvilable(User user)
	{
		List<User> users = userDao.findAll();
		Optional<User> usr = users.stream().filter(u->u.getName().equals(user.getName())).findAny();
		System.out.println(users);
		if(usr.isEmpty())
			return true;
		else throw new UserException("User name already Exists");
		
	}
	
	public User enrolInGame(User user , int gameId)
	{
		List<Game> games = gameDao.findAll();
		Optional<Game> gm = games.stream().filter(g->g.getId()==gameId).findAny();
		if(!gm.isEmpty())
		{	
			if (user.getGames()==null)
			user.setGames(""+gameId);
			else
				user.setGames(user.getGames()+","+gameId);
			
			gm.get().getRegisteredPlayers().add(user);
			gameDao.save(gm.get());
			userDao.save(user);
			return user;
		}
		else 
			throw new UserException("Game does not exist");
		
	}
	
	public User EncryptPassword(User user)
	{
		char [] pass = user.getPassword().toCharArray();
		for(int i =0 ;i<pass.length;i++)
		pass[i]= (char)(pass[i]+10);
		user.setPassword(String.valueOf(pass));
		return user;
	}

	

}
