package com.panBattle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panBattle.modal.Admin;

public interface AdminDao extends JpaRepository<Admin, Long> {

}
