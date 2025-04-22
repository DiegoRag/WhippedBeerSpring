package com.whipped_beer.app.resources;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
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
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
	    System.out.println("Entrou no /login");

		
		  var user = userRepository.findByUsuario(loginRequest.username());
		  System.out.println("Usuário encontrado: " + user.get().getUsuario());
		  System.out.println("Senha fornecida: " + loginRequest.password());

		  if (user.isEmpty()) {
			    System.out.println("Usuário não encontrado: " + loginRequest.username());
			    throw new BadCredentialsException("Usuário não encontrado!");
			}

			if (!user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
			    System.out.println("Senha incorreta para o usuário: " + loginRequest.username());
			    throw new BadCredentialsException("Senha incorreta!");
			}

	        
	        System.out.println("Usuário encontrado: " + user.get().getUsuario()); // Verifique se o usuário foi encontrado.

	        var now = Instant.now();
	        var expiresIn = 30L;
	        
	        var claims = JwtClaimsSet.builder()
	        		.issuer("WBS")
	        		.subject(user.get().getId().toString())
	        		.issuedAt(now)
	        		.expiresAt(now.plus(expiresIn, ChronoUnit.DAYS))
	        		.build();
	        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	        System.out.println("JWT Token: " + jwtValue); // Verifique se o token está sendo gerado.

	         
	        return ResponseEntity.ok(new LoginResponse(jwtValue, expiresIn));
	        
	        
	        
	        
	        				
	        		
	}
	
	
	
}
