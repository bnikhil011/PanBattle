package com.panBattle.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.panBattle.modal.User;

public interface UserDao extends JpaRepository<User, Long> {

	@Query("select u from User u where u.name=:n and u.password=:p")
	public Optional<User> findUser(@Param("n")String username,@Param("p") String pass);
}
