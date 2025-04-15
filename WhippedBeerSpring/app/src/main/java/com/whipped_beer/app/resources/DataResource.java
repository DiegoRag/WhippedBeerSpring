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

import com.whipped_beer.app.entities.Data;
import com.whipped_beer.app.services.DataService;
@RestController
@RequestMapping(value = "/dados")
public class DataResource {
	

		@Autowired
		private DataService service;
		
		@GetMapping
		public ResponseEntity<List<Data>> findAll() {
			List<Data> list = service.findAll(); 
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Data> findById(@PathVariable Integer id){
			Data obj = service.findById(id);
			return ResponseEntity.ok().body(obj); 
		}
		
		
		
		@PostMapping
		public ResponseEntity<Data> insert(@RequestBody Data obj){
		  obj = service.insert(obj);
		  URI uri = ServletUriComponentsBuilder
				  .fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(obj.getId())
				  .toUri();
		  return ResponseEntity.created(uri).body(obj);
		}
	 	
		
		
	}
