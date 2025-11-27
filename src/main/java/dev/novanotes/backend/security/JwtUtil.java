package dev.novanotes.backend.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final SecretKey secretKey;
	private final long EXPIRATION;
	
	public JwtUtil(@Value ("${security.jwt.secret-key}") String SECRET, @Value ("${security.jwt.expiration-time}") long expiration) {
		this.secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());
		this.EXPIRATION = expiration;
	}
	
	public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey, Jwts.SIG.HS256)
                .compact();
    }
	
	public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
	
	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
	
	private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
	}
}
