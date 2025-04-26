package com.whipped_beer.app.services;

import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    private final JwtEncoder jwtEncoder;

    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(String userId) {
        var now = Instant.now();
        var expiresIn = 30L;

        var claims = JwtClaimsSet.builder()
                .issuer("WBS")
                .subject(userId)
                .issuedAt(now)
                .expiresAt(now.plus(expiresIn, ChronoUnit.DAYS))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
