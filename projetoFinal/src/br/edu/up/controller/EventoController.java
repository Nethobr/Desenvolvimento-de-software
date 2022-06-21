package br.edu.up.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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

	public static List<Evento> localizarNome(String nome) 
	{
		iniciarEm();
		
		TypedQuery<Evento> query = em.createQuery(
		"SELECT e FROM Evento e WHERE e.nome_evento = :name", Evento.class);
		List<Evento> evento = query.setParameter("name", nome).getResultList();
		return evento;
	}
	
	// CRUD'S DE EDIÇÃO DO BANCO
	public static Integer salvarEvento(Evento evento)
	{
		iniciarEm();
		
		em.getTransaction().begin();
		em.persist(evento);
		em.getTransaction().commit();
		
		return evento.getId();
	}	// Fim salvarEvento

	public static void atualizarEvento(Evento evento)
	{
		em.getTransaction().begin();
		em.merge(evento);
		em.getTransaction().commit();
	}	// Fim atualizarEvento
	
	public static void deletarEvento(Integer id)
	{
		Evento evento = em.find(Evento.class, id);
		em.getTransaction().begin();
		em.remove(evento);
		em.getTransaction().commit();
	}	// Fim deletarEvento
	
	public static List<Evento> localizarComCatagoria (Integer cat)
	{
		iniciarEm();
		
		TypedQuery<Evento> query = em.createQuery(
		"SELECT e FROM Evento e WHERE e.id_categoria = :name", Evento.class);
		List<Evento> evento = query.setParameter("name", cat).getResultList();
		return evento;
	}	// Fim localizarComCatagoria
}	// Fim EventoController