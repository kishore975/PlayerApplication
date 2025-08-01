package com.practice.PlayerApplication.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private String secKey="Iam-a-secret-key-Iam-a-secret-key-Iam-a-secret-key";

	public String generateToken(String playerName) {
		
		Map<String, Object> claims= new HashMap<>();
		
		return Jwts.builder()
				   .claims()
				   .add(claims)
				   .subject(playerName)
				   .issuedAt(new Date(System.currentTimeMillis()))
				   .expiration(new Date(System.currentTimeMillis()+60*60*10))
				   .and().signWith(getSignedKey()).compact();
	
	}
	
	public SecretKey getSignedKey() {
		byte keyBytes[]=secKey.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
