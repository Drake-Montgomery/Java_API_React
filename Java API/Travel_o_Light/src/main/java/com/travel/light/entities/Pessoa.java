package com.travel.light.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.travel.light.entities.Pessoa;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Nome;
	private String Sobrenome;
	private String Email;
	private String Senha;
	private String Origem;
	private String Destino;
	
	public Pessoa() {
	}
	
	public Pessoa(Long id, String nome, String email, String senha, String origem, String destino) {
		Id = id;
		Nome = nome;
		Email = email;
		Senha = senha;
		Origem = origem;
		Destino = destino;
	}

	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getOrigem() {
		return Origem;
	}
	
	public void setOrigem(String origem) {
		Origem = origem;
	}
	
	public String getDestino() {
		return Destino;
	}
	
	public void setDestino(String destino) {
		Destino = destino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(Id, other.Id);
	}
}
