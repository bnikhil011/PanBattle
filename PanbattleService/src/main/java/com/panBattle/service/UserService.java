package com.panBattle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panBattle.modal.User;
import com.panBattle.dao.UserDao;
import com.panBattle.exceptions.ModalNullException;
@Service
public class UserService  {
	@Autowired
	UserDao userDao;
	
	
	public User save(User user) {
		
		if(UserNullCheck(user))
		throw new ModalNullException("Some required data is missing in User payload send");
		return userDao.save(user);
	}

	
	public User update(User user) {
		
		return null;
	}

	
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean UserNullCheck(User user)
	{
		if((user.getEmailid()==null || user.getEmailid().isEmpty()) 
		|| (user.getName()== null || user.getName().isEmpty())
		|| (user.getPassword()==null || user.getPassword().isEmpty()))
		return true;
		else
			return false;
	}

}
