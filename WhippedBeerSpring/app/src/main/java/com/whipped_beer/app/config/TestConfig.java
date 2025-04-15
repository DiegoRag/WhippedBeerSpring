package com.whipped_beer.app.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.whipped_beer.app.entities.Data;
import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.DataRepository;
import com.whipped_beer.app.repositories.UserRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DataRepository dataRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// LocalDate date1 = LocalDate.of(2025, 4, 29);
		 //LocalDate date2 = LocalDate.of(2025, 4, 30);
		
		 //User u1 = new User(null, "Joaozinho Bom De Bola", "Joao", "joao@gmail.com", "123456", 1);
		 //User u2 = new User(null, "Gustavinho Da awp", "Gustavo", "Gustavo@gmail.com", "12345", 1);
		
		 //Data d1 = new Data(null, 22, date1);   
		 //Data d2 = new Data(null, 23, date2);   
		   
		 //userRepository.saveAll(Arrays.asList(u1, u2));
		 //dataRepository.saveAll(Arrays.asList(d1,d2));
	}

}
