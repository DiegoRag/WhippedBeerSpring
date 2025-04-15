package com.whipped_beer.app.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.UserRepository;



@Service
public class UserService {
		
		@Autowired
		private UserRepository repository;
	
		public List<User> findAll(){
			return repository.findAll();
		}
		
		public User findById(Integer id) {
			Optional<User> obj = repository.findById(id);
			return obj.get();
		}
		
		public User insert(User obj) {
			return repository.save(obj);
		}
}
