package com.practice.PlayerApplication.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class PlayerDto {
	
	private int playerId;
	private String playerName;
	private String playerGame;
	private int playerAge;
	
	
	public PlayerDto() {
		super();
	}

	public PlayerDto(int playerId, String playerName, int playerAge, String playerGame) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.playerGame = playerGame;
		this.playerAge = playerAge;
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
	public String getPlayerGame() {
		return playerGame;
	}
	public void setPlayerGame(String playerGame) {
		this.playerGame = playerGame;
	}

	public int getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}

	
	
	
	

}
