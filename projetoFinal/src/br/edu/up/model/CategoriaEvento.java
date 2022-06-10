package br.edu.up.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_evento")
public class CategoriaEvento 
{
	// VAR'S
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_cat;
	
	public Integer getId_cat() {
		return id_cat;
	}

	private String nome_categoria;
	
	private String desc_categoria;


	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	public String getDesc_categoria() {
		return desc_categoria;
	}

	public void setDesc_categoria(String desc_categoria) {
		this.desc_categoria = desc_categoria;
	}
	
}
