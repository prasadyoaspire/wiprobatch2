package com.abc.authservice.service;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	public static final String SECRET= "JFKJU484334939ERFDDFDFJDFJDFKDFOR25DFDDFKFDIDFKDFODFLDFLDODFLDFODF2EODDFDFPDF";

	// generate JWT token
	public String generateToken(String username) {
	Date currentDate = new Date();
	Date expireDate = new Date(currentDate.getTime() + 1000 * 60 * 30);

	String token = Jwts.builder().subject(username).issuedAt(new Date()).expiration(expireDate)
					.signWith(getSignKey()).compact();

		return token;
	}

	private Key getSignKey() {
			byte[] keyBytes = Decoders.BASE64.decode(SECRET);
			return Keys.hmacShaKeyFor(keyBytes);
	}

	// validate JWT token
	public boolean validateToken(String token) {
		Jwts.parser().verifyWith((SecretKey) getSignKey()).build().parse(token);
		return true;
	}

}
