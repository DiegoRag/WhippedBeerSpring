package com.whipped_beer.app.resources.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

	
	@NotNull(message = "O usuario não pode ser nulo.")
    @Size(min = 3, max = 30, message = "O nome de usuario deve ter entre 3 e 30 caracteres.")
	private String usuario;
	@NotNull(message = "O nome não pode ser nulo.")
    @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres.")
	private String nome;
	@NotNull(message = "O email não pode ser nulo.")
    @Email(message = "Email inválido.")
	private String email;
	@NotNull(message = "A senha não pode ser nula.")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
	private String senha;
	
	public UserRegisterDTO() {
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
