package br.edu.up.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Fala que é uma entidade
@Table(name = "livro") // O nome ue vai ficar na tabela
public class Livro 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private int id; // fala qual é a chave primária
	
	// Outros campos da tabela
	private String titulo;
	private String isbn;
	
	//Getters e Setters para acessar a tabela
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}	// Fim getters e setters
}	// Fim Livro
