package com.whipped_beer.app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whipped_beer.app.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User>findByUsuario(String usuario);
}