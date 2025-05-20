package com.whipped_beer.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whipped_beer.app.entities.Data;
import com.whipped_beer.app.repositories.DataRepository;
import com.whipped_beer.app.resources.dto.DataRegisterDTO;
@Service
public class DataService {
	
	@Autowired
	private DataRepository repository;

	public List<Data> findAll(){
		return repository.findAll();
	}
	
	public Data findById(Integer id) {
		Optional<Data> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	public Data insert(Data obj) {
		return repository.save(obj);
	}
	
	public Data insert(DataRegisterDTO dto) {
	    Data data = new Data();
	    data.setTemperatura(dto.getTemperatura());

	    return repository.save(data);
	}
}

