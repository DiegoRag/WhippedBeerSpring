package com.whipped_beer.app.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.UserRepository;
import com.whipped_beer.app.resources.dto.LoginRequest;
import com.whipped_beer.app.resources.dto.LoginResponse;
import com.whipped_beer.app.resources.dto.UserPublicDTO;
import com.whipped_beer.app.resources.dto.UserRegisterDTO;
import com.whipped_beer.app.services.TokenService;
import com.whipped_beer.app.services.UserService;

@RestController
@RequestMapping("/auth") // ou "/register"
public class AuthResource {
	@Autowired
	private TokenService tokenService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
  
   
    
    @Autowired
    private UserService service;

    @PostMapping("/cadastro")
    public ResponseEntity<UserPublicDTO> insert(@RequestBody UserRegisterDTO dto) {
        // Converte o DTO de cadastro para uma entidade User
        User user = service.insert(dto);

        // Converte a entidade User para UserPublicDTO para não expor a senha
        UserPublicDTO userPublicDTO = new UserPublicDTO(user);

        // Cria a URI de resposta para o recurso recém-criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        // Retorna o UserPublicDTO com a URI do recurso recém-criado
        return ResponseEntity.created(uri).body(userPublicDTO);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var user = userRepository.findByUsuario(loginRequest.username());

        if (user.isEmpty() || !user.get().isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new BadCredentialsException("Usuário ou senha incorreto");
        }

        // Gerando o token com o serviço
        String token = tokenService.generateToken(user.get().getId().toString());

        return ResponseEntity.ok(new LoginResponse(token, 30L));  // Token e expiração
    }
}