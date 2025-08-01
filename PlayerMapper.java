package com.practice.PlayerApplication.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.practice.PlayerApplication.dto.PlayerDto;
import com.practice.PlayerApplication.model.Player;

@Component
public class PlayerMapper {
	
	public PlayerDto jpaToDto(Player player) {
		PlayerDto playerDto= new PlayerDto(player.getPlayerId(), player.getPlayerName(), player.getPlayerGame());
		return playerDto;
	}

	public Player dtoToJpa(PlayerDto playerDto) {
		Player player= new Player(playerDto.getPlayerId(), playerDto.getPlayerName(), playerDto.getPlayerGame());
		return player;
	}
	
	
	public List<PlayerDto> jpaToDtoList(List<Player> players) {
		List<PlayerDto> list= new ArrayList<>();
		for(Player eachPlayer:players) {
			list.add(jpaToDto(eachPlayer));
		}
        return list; 
    }

    public List<Player> dtoToJpaList(List<PlayerDto> playerDtos) {
       List<Player> list= new ArrayList<>();
       for(PlayerDto eachPlayerDto: playerDtos) {
    	   list.add(dtoToJpa(eachPlayerDto));
       }
       return list;
    }




}
