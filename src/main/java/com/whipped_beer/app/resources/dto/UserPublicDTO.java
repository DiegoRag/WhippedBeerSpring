package com.whipped_beer.app.resources.dto;

import com.whipped_beer.app.entities.User;

// Classe DTO para retornar os dados públicos do usuário
public record UserPublicDTO(Integer id, String usuario, String nome, String email) {

    // Construtor que converte um objeto User para UserPublicDTO
    public UserPublicDTO(User user) {
        this(user.getId(), user.getUsuario(), user.getNome(), user.getEmail());
    }
}
