package com.whipped_beer.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.DataRepository;
import com.whipped_beer.app.repositories.UserRepository;
import com.whipped_beer.app.services.UserService;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService service;
	
	@Autowired
	DataRepository dataRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// LocalDate date1 = LocalDate.of(2025, 4, 29);
		 //LocalDate date2 = LocalDate.of(2025, 4, 30);
		
		 //User u1 = new User(null, "Joaozinho Bom De Bola", "Joao", "joao@gmail.com", "123456", 1);
		 //User u2 = new User(null, "Gustavinho Da awp", "Gustavo", "Gustavo@gmail.com", "12345", 1);
		
	//	var userAdmin = userRepository.findByUsuario("admin");

		
		//userAdmin.ifPresentOrElse(
		//	    user -> System.out.println("Admin já existe"),
		//	    () -> {	
		//	        User admin = new User(null, "admin2", "Joao", "diegoAdmin@gmail.com", "12345", 1);
		//	        service.insert(admin);
		//	    }
		//	);
		
	//User user = new User(null, "joazito", "joaozito", "joaozitoLegal@gmail.com", "!@#", 1);
		//service.insert(user);
		
	//service.insert(new User(null, "testonildo", "testonildoDaSilva", "testonildodasilva@email.com", "123456", 1));

		
			
		   
		
		 //Data d1 = new Data(null, 22, date1);   
		 //Data d2 = new Data(null, 23, date2);   
		   
		 //userRepository.saveAll(Arrays.asList(u1, u2));
		 //dataRepository.saveAll(Arrays.asList(d1,d2));
	}

}