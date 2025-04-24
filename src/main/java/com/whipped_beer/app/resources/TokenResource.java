package com.whipped_beer.app.resources;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.whipped_beer.app.repositories.UserRepository;
import com.whipped_beer.app.resources.dto.LoginRequest;
import com.whipped_beer.app.resources.dto.LoginResponse;

@RestController
public class TokenResource {

	private final JwtEncoder jwtEncoder;
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public TokenResource(JwtEncoder jwtEncoder, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.jwtEncoder = jwtEncoder;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		
	}
	
	@GetMapping("/status")
	public Map<String, Object> status() {
	    return Map.of(
	        "status", "OK",
	        "timestamp", Instant.now().toString()
	    );
	}

	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){

		
		  var user = userRepository.findByUsuario(loginRequest.username());
	

		  if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
			    throw new BadCredentialsException("Usuario ou senha incorreto");
			}

			if (!user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
			    System.out.println("Senha incorreta para o usuário: " + loginRequest.username());
			    throw new BadCredentialsException("Senha incorreta!");
			}
			
			

	        

	        var now = Instant.now();
	        var expiresIn = 30L;
	        
	        var claims = JwtClaimsSet.builder()
	        		.issuer("WBS")
	        		.subject(user.get().getId().toString())
	        		.issuedAt(now)
	        		.expiresAt(now.plus(expiresIn, ChronoUnit.DAYS))
	        		.build();
	        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

	         
	        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
	        
	        
	        
	        
	        				
	        		
	}
	
	
	
}
