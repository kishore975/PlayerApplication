package com.practice.PlayerApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.PlayerApplication.dto.CredsDto;
import com.practice.PlayerApplication.dto.PlayerDto;
import com.practice.PlayerApplication.model.Player;
import com.practice.PlayerApplication.service.PlayerService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping("/test")
	public String doTest() {
		return "Player Service is up!";
	}
	
	@GetMapping("/csrftoken")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
	@PostMapping("/registering")
	public ResponseEntity<PlayerDto> addPlayer(@RequestBody Player player) {
		return new ResponseEntity<PlayerDto>(playerService.registerPlayer(player),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<PlayerDto> updatePlayer(@RequestBody Player player) {
		return new ResponseEntity<PlayerDto>(playerService.updatePlayer(player), HttpStatus.OK);
	}
	
	@GetMapping("/id/{pId}")
	public ResponseEntity<PlayerDto> getPlayerById(@PathVariable int pId){
		return new ResponseEntity<PlayerDto>(playerService.getPlayerById(pId), HttpStatus.OK);
	}
	
	@GetMapping("/players/all")
	public ResponseEntity<List<PlayerDto>> getAllPlayers(){
		return new ResponseEntity<List<PlayerDto>>(playerService.getAllPlayers(), HttpStatus.OK);
	}
	
	
	@GetMapping("/game/{game}")
	public ResponseEntity<List<PlayerDto>> getPlayersByGame(@PathVariable String game){
		return new ResponseEntity<List<PlayerDto>>(playerService.getPlayersByPlayerGame(game),HttpStatus.OK);
	}
	
	@GetMapping("/unpwd/{username}")
	public ResponseEntity<CredsDto> getUsernamePassword(@PathVariable String username ){
		return new ResponseEntity<CredsDto>(playerService.getUsernamePassword(username),HttpStatus.OK);
	}
	
	@DeleteMapping("/{pId}")
	public ResponseEntity<String> deletePlayer(@PathVariable int pId) {
		return new ResponseEntity<String>(playerService.deletePlayer(pId), HttpStatus.OK);
	}
	
	@GetMapping("/player/signinn")
	public ResponseEntity<PlayerDto> signIn(@RequestBody CredsDto credsDto){
		return new ResponseEntity<PlayerDto>(playerService.signIn(credsDto), HttpStatus.OK);
	}
	
	@GetMapping("/player/loginn")
	public ResponseEntity<String> loggInn(@RequestBody CredsDto credsDto){
		return new ResponseEntity<String>(playerService.verify(credsDto), HttpStatus.OK);
	}
	

}
