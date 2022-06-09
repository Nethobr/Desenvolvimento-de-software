package br.edu.up.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivel_us")
public class NivelUs 
{
	// VAR'S
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome_nivel;
	
	private String permicoes_nivel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_nivel() {
		return nome_nivel;
	}

	public void setNome_nivel(String nome_nivel) {
		this.nome_nivel = nome_nivel;
	}

	public String getPermicoes_nivel() {
		return permicoes_nivel;
	}

	public void setPermicoes_nivel(String permicoes_nivel) {
		this.permicoes_nivel = permicoes_nivel;
	}
	
}