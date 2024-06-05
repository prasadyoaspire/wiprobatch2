package com.abc.gateway.util;

import java.security.Key;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	public static final String SECRET = "JFKJU484334939ERFDDFDFJDFJDFKDFOR25DFDDFKFDIDFKDFODFLDFLDODFLDFODF2EODDFDFPDF";

    // validate JWT token
	public boolean validateToken(String token) {
		Jwts.parser().verifyWith((SecretKey) getSignKey()).build().parse(token);
		return true;
	}
	
	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
