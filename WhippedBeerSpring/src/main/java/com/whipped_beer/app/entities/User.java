package com.whipped_beer.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.whipped_beer.app.resources.dto.LoginRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "usuarios")
public class User implements Serializable {
	 
		
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer id;
	@Column(unique = true)
	private String usuario;
	private String nome;
	private String email;
	private String senha;
	private Integer ativo;
	private LocalDate criadoEm;
	private LocalDate alteradoEm;
	
	public User () {
		
	}
	public User(Integer id, String usuario, String nome,
	String email, String senha, Integer ativo) {
		
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ativo = ativo;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String setSenha(String senha) {
		
		return this.senha = senha;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	public LocalDate getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}
	public LocalDate getAlteradoEm() {
		return alteradoEm;
	}
	public void setAlteradoEm(LocalDate alteradoEm) {
		this.alteradoEm = alteradoEm;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
	 public void hashAndSetSenha(String senha, PasswordEncoder encoder) {
	        this.senha = encoder.encode(senha + "BlackStar"); 
	    }
	
	 public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
		    // Adiciona "BlackStar" à senha fornecida pelo usuário antes de compará-la
		    String senhaSct = loginRequest.password() + "BlackStar";
		    return passwordEncoder.matches(senhaSct, this.senha);
		}

	
	
	
}