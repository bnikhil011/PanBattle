package com.panBattle.modal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long winPrice;
	private long enterPrice;
	private long totalplayersAllowed;
	@OneToMany
	private List<User> registeredPlayers = new ArrayList<User>();
	private Date date;
	private int durition;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getWinPrice() {
		return winPrice;
	}
	public void setWinPrice(long winPrice) {
		this.winPrice = winPrice;
	}
	public long getEnterPrice() {
		return enterPrice;
	}
	public void setEnterPrice(long enterPrice) {
		this.enterPrice = enterPrice;
	}
	public long getTotalplayersAllowed() {
		return totalplayersAllowed;
	}
	public void setTotalplayersAllowed(long totalplayersAllowed) {
		this.totalplayersAllowed = totalplayersAllowed;
	}
	public List<User> getRegisteredPlayers() {
		return registeredPlayers;
	}
	public void setRegisteredPlayers(List<User> registeredPlayers) {
		this.registeredPlayers = registeredPlayers;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDurition() {
		return durition;
	}
	public void setDurition(int durition) {
		this.durition = durition;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", winPrice=" + winPrice + ", enterPrice=" + enterPrice + ", totalplayersAllowed="
				+ totalplayersAllowed + ", registeredPlayers=" + registeredPlayers + ", date=" + date + ", durition="
				+ durition + "]";
	}

	
}
