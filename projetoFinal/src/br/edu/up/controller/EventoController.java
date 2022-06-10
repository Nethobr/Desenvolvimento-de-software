package br.edu.up.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.up.model.Evento;

public class EventoController 
{
	// Conectando a base
	static EntityManagerFactory emf;
	static EntityManager em;
	public static void iniciarEm() {
		emf = Persistence.createEntityManagerFactory("prj-final");
		em = emf.createEntityManager();
	}
	
	// Função para listar os eventos registrados
	public static List<Evento> ListarEventos()
	{
		iniciarEm();
		List<Evento> eventos = em.createQuery("from Evento", Evento.class).getResultList();
		return eventos;
	}	// Fim ListarEventos
	
	public static Evento localizar(Integer id) {
		iniciarEm();
		Evento evento = em.find(Evento.class, id);
		return evento;
	}

	
	public static Integer salvarEvento (Evento evento)
	{
		iniciarEm();
		
		em.getTransaction().begin();
		em.persist(evento);
		em.getTransaction().commit();
		
		return evento.getId();
	}	// Fim salvarEvento

	
}	// Fim EventoController