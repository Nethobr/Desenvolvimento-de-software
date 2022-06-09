package br.edu.up.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.up.model.Usuario;

public class LoginController 
{
	// Conectando a base
	static EntityManagerFactory emf;
	static EntityManager em;
	public static void iniciarEm() {
		emf = Persistence.createEntityManagerFactory("prj-final");
		em = emf.createEntityManager();
	}
	
	public static String logado (String nome_us, String senha_us) 
	{
		iniciarEm();
		
		String ok = "";
		
		Usuario us = em.find(Usuario.class, nome_us);
		
		if (us.getNome_us() != nome_us && us.getSenha_us() == senha_us)
		{
			ok = "Deu.";
		} else {
			ok = "Não deu!";
		}
		
		return ok;
	}
}
