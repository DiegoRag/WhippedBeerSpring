package com.whipped_beer.app.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.UserRepository;



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
		
		    public User insert(User obj) {
		        // Hash the password before saving
		        String senhaFinal = obj.getSenha();
		        obj.hashAndSetSenha(senhaFinal, passwordEncoder); // Hash and set the password hash

		        return repository.save(obj); // Save the entity with the hashed password
		    }
		
		public Optional<User> findByUsuario(String usuario) {
		    return repository.findByUsuario(usuario);
		}

}