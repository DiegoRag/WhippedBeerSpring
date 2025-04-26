package com.whipped_beer.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whipped_beer.app.entities.Data;
import com.whipped_beer.app.entities.User;
import com.whipped_beer.app.repositories.DataRepository;
import com.whipped_beer.app.resources.dto.UserRegisterDTO;
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
	
	public User insert(UserRegisterDTO dto) {
        // Criação do objeto User a partir do DTO de cadastro
        Data data = new Data();
        user.setUsuario(dto.getUsuario());
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());  // Lembre-se que a senha será hashada antes de ser salva
        user.hashAndSetSenha(dto.getSenha(), passwordEncoder);
        user.setAtivo(1);  // Usuário ativo
        return repository.save(user);  // Salva o usuário no banco
    }
}