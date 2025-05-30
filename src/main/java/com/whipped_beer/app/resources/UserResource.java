package com.whipped_beer.app.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.services.UserService;

@RestController
@RequestMapping(value = "/usuarios")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
	  obj = service.insert(obj);
	  URI uri = ServletUriComponentsBuilder
			  .fromCurrentRequest()
			  .path("/{id}")
			  .buildAndExpand(obj.getId())
			  .toUri();
	  return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping(value = "/{usuario}")
	public ResponseEntity<User> findByUsuario(@PathVariable String usuario) {
	    return service.findByUsuario(usuario)
	        .map(ResponseEntity::ok)
	        .orElse(ResponseEntity.notFound().build());
	}

	
	
	
	
}