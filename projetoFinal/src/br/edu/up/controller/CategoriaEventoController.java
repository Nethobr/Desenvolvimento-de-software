package br.edu.up.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.up.model.CategoriaEvento;

public class CategoriaEventoController 
{
	// Conectando a base
	static EntityManagerFactory emf;
	static EntityManager em;
	public static void iniciarEm() {
		emf = Persistence.createEntityManagerFactory("prj-final");
		em = emf.createEntityManager();
	}
	
	public static List<CategoriaEvento> ListarCategorias()
	{
		iniciarEm();
		List<CategoriaEvento> categorias = em.createQuery("from CategoriaEvento", CategoriaEvento.class).getResultList();
		return categorias;
	}	// Fim ListarEventos
	
	public static Integer salvaCategoria (CategoriaEvento categoria)
	{
		iniciarEm();
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		
		return categoria.getId_cat();
	}	// Fim salvaCategoria
	
	public static CategoriaEvento localizar(Integer id) {
		iniciarEm();
		CategoriaEvento cat = em.find(CategoriaEvento.class, id);
		return cat;
	}
}
