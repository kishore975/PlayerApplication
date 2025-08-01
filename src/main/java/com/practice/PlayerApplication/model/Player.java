package com.practice.PlayerApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="player_id")
	private int playerId;
	@Column(name="player_name")
	private String playerName;
	@Column(name="player_age")
	private int playerAge;
	@Column(name="player_game")
	private String playerGame;
	@Column(name = "password")
	private String password;	
	
	
	public Player() {
		super();
	}

	public Player(int playerId2, String playerName2, int playerAge,  String playerGame2) {
		// TODO Auto-generated constructor stub
	}

	public Player(String playerName2, String password2) {
		// TODO Auto-generated constructor stub
	}

	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerAge() {
		return playerAge;
	}
	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}
	public String getPlayerGame() {
		return playerGame;
	}
	public void setPlayerGame(String playerGame) {
		this.playerGame = playerGame;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
