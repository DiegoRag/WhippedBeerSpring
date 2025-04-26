package com.whipped_beer.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whipped_beer.app.entities.Data;
import com.whipped_beer.app.repositories.DataRepository;
@Service
public class DataService {
	
	@Autowired
	private DataRepository repository;

	public List<Data> findAll(){
		return repository.findAll();
	}
	
	public Data findById(Integer id) {
		Optional<Data> obj = repository.findById(id);
		return obj.get();
	}
	
	public Data insert(Data obj) {
		return repository.save(obj);
	}
}