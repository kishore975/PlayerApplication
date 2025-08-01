package com.practice.PlayerApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.PlayerApplication.dto.CredsDto;
import com.practice.PlayerApplication.dto.PlayerDto;
import com.practice.PlayerApplication.model.Player;

@Service
public interface PlayerService {
	
	public PlayerDto registerPlayer(Player player);
	
	public PlayerDto updatePlayer(Player player);
	
	public PlayerDto getPlayerById(int playerId);
	
	public List<PlayerDto> getPlayersByPlayerGame(String playerGame);
	
	public List<PlayerDto> getAllPlayers();
	
	public String deletePlayer(int playerId);
	
	public CredsDto getUsernamePassword(String username);
	
	public PlayerDto signIn(CredsDto credsDto);
	
	public String verify(CredsDto credsDto);

}
