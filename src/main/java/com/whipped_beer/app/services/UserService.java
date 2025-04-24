package com.whipped_beer.app.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.UserRepository;
import com.whipped_beer.app.resources.dto.UserRegisterDTO;



@Service
public class UserService {
		
		@Autowired
		private UserRepository repository;

		private final BCryptPasswordEncoder passwordEncoder;
		
		    public UserService(BCryptPasswordEncoder passwordEncoder) {
		        this.passwordEncoder = passwordEncoder;
		    }


	
		public List<User> findAll(){
			return repository.findAll();
		}
		
		   public User findById(Integer id) {
		        Optional<User> obj = repository.findById(id);
		        return obj.orElseThrow(() -> new RuntimeException("User not found"));
		    }
		
		   public User insert(UserRegisterDTO dto) {
		        // Criação do objeto User a partir do DTO de cadastro
		        User user = new User();
		        user.setUsuario(dto.getUsuario());
		        user.setNome(dto.getNome());
		        user.setEmail(dto.getEmail());
		        user.setSenha(dto.getSenha());  // Lembre-se que a senha será hashada antes de ser salva
		        user.hashAndSetSenha(dto.getSenha(), passwordEncoder);
		        user.setAtivo(1);  // Usuário ativo
		        return repository.save(user);  // Salva o usuário no banco
		    }
		
		public Optional<User> findByUsuario(String usuario) {
		    return repository.findByUsuario(usuario);
		}

}