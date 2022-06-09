package br.edu.up.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario  extends NivelUs
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome_us;
	
	private String senha_us;
	
	private Integer nivel_us;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_us() {
		return nome_us;
	}

	public void setNome_us(String nome_us) {
		this.nome_us = nome_us;
	}

	public String getSenha_us() {
		return senha_us;
	}

	public void setSenha_us(String senha_us) {
		this.senha_us = senha_us;
	}

	public Integer getNivel_us() {
		return nivel_us;
	}

	public void setNivel_us(Integer nivel_us) {
		this.nivel_us = nivel_us;
	}
}
