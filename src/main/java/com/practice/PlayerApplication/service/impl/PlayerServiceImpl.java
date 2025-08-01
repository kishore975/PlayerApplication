package com.practice.PlayerApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.PlayerApplication.dto.CredsDto;
import com.practice.PlayerApplication.dto.PlayerDto;
import com.practice.PlayerApplication.mapper.PlayerMapper;
import com.practice.PlayerApplication.model.Player;
import com.practice.PlayerApplication.repository.PlayerRepo;
import com.practice.PlayerApplication.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(12);

	@Autowired
	PlayerRepo playerRepo;
	
	@Autowired
	PlayerMapper playerMapper;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public PlayerDto registerPlayer(Player player) {
		player.setPassword(bCryptPasswordEncoder.encode(player.getPassword()));
		 playerRepo.save(player);
		 return playerMapper.jpaToDto(player);
	}

	
	public PlayerDto updatePlayer(Player player) {
		player.setPassword(bCryptPasswordEncoder.encode(player.getPassword()));
		 Player savedPlayer=playerRepo.save(player);
		 return playerMapper.jpaToDto(savedPlayer);
	}

	
	public PlayerDto getPlayerById(int playerId) {
		 Player retrievedPlayer= playerRepo.findById(playerId).orElseThrow(() -> new RuntimeException("No player found with id"+playerId));
		 return playerMapper.jpaToDto(retrievedPlayer);
	}

	
	public List<PlayerDto> getPlayersByPlayerGame(String playerGame) {
		List<Player> player=playerRepo.getPlayersByPlayerGame(playerGame);
		return playerMapper.jpaToDtoList(player);
	}


	public List<PlayerDto> getAllPlayers() {
		List<Player> players= playerRepo.findAll();
		return playerMapper.jpaToDtoList(players);
	}

	
	public String deletePlayer(int playerId) {
		 playerRepo.deleteById(playerId);
		 return "Deleted.";
	}

	public CredsDto getUsernamePassword(String username) {
		Player player=playerRepo.findByPlayerName(username);
		return playerMapper.jpaToDtoCreds(player);
	}

	
	public PlayerDto signIn(CredsDto credsDto) {
		Player player=playerRepo.findByPlayerName(credsDto.getPlayerName());
		//if(player.getPassword().equals(credsDto.getPassword())) {
		if(player!=null && passwordEncoder.matches(credsDto.getPassword(),player.getPassword())) {
			PlayerDto playerrDto=playerMapper.jpaToDto(player);
			return playerrDto;
		}else {
			throw new RuntimeException("Invalid Deatils");
		}
		
	}


	@Override
	public String verify(CredsDto credsDto) {
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credsDto.getPlayerName(), credsDto.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(credsDto.getPlayerName());
		}
		return "Filed";
	}

}
