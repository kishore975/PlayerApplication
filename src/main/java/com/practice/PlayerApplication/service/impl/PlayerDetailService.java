package com.practice.PlayerApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.PlayerApplication.model.Player;
import com.practice.PlayerApplication.model.PlayerPrincipal;
import com.practice.PlayerApplication.repository.PlayerRepo;

@Service
public class PlayerDetailService implements UserDetailsService{
	
	@Autowired
	PlayerRepo playerRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		
		Player player=playerRepo.findByPlayerName(username);
		if(player==null)
			throw new UsernameNotFoundException("User not found.");
		return new PlayerPrincipal(player);
		
	}

}
