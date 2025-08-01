package com.practice.PlayerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.PlayerApplication.dto.CredsDto;
import com.practice.PlayerApplication.dto.PlayerDto;
import com.practice.PlayerApplication.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
	
	public List<Player> getPlayersByPlayerGame(String playerGame);
	
	public Player findByPlayerName(String playerName);

}
