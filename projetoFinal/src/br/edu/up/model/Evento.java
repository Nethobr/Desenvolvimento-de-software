package br.edu.up.model;

//import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento
{
	// VAR'S
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String nome_evento;
	public String getNome_evento() {
		return nome_evento;
	}
	public void setNome_evento(String nome_evento) {
		this.nome_evento = nome_evento;
	}
	
	private String data_evento;
	public String getData_evento() {
		return data_evento;
	}
	public void setData_evento(String data_evento) {
		this.data_evento = data_evento;
	}

	private String descricao_evento;
	public String getDescricao_evento() {
		return descricao_evento;
	}
	public void setDescricao_evento(String descricao_evento) {
		this.descricao_evento = descricao_evento;
	}
}	// Fim EventoModel