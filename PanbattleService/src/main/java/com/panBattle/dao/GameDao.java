package com.panBattle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panBattle.modal.Game;

public interface GameDao extends JpaRepository<Game, Integer> {

}
