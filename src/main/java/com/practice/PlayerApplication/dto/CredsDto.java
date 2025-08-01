package com.practice.PlayerApplication.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CredsDto {
	
	private String playerName;
	private String password;
	
	public CredsDto(String playerName, String password) {
		super();
		this.playerName = playerName;
		this.password = password;
	}

	public CredsDto() {
		super();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
