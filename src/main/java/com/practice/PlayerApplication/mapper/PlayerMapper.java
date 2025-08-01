package com.practice.PlayerApplication.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.practice.PlayerApplication.dto.CredsDto;
import com.practice.PlayerApplication.dto.PlayerDto;
import com.practice.PlayerApplication.model.Player;

@Component
public class PlayerMapper {
	
	public PlayerDto jpaToDto(Player player) {
		PlayerDto playerDto= new PlayerDto(player.getPlayerId(), player.getPlayerName(),player.getPlayerAge(), player.getPlayerGame());
		return playerDto;
	}

	public Player dtoToJpa(PlayerDto playerDto) {
		Player player= new Player(playerDto.getPlayerId(), playerDto.getPlayerName(), playerDto.getPlayerAge(), playerDto.getPlayerGame());
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
    
    
    
//    public List<PlayerDto> jpaToDtoList(List<Player> players) {
//        return players.stream()
//                      .map(this::jpaToDto)
//                      .collect(Collectors.toList());
//    }

//    public List<Player> dtoToJpaList(List<PlayerDto> playerDtos) {
//        return playerDtos.stream()
//                         .map(this::dtoToJpa)
//                         .collect(Collectors.toList());
//    }
    
    public CredsDto jpaToDtoCreds(Player player) {
    	CredsDto credsDto= new CredsDto(player.getPlayerName(), player.getPassword());
		return credsDto;
	}

	public Player dtoToJpaCreds(CredsDto credsDto) {
		Player player= new Player(credsDto.getPlayerName(), credsDto.getPassword());
		return player;
	}
	
	
	
	
	

}
