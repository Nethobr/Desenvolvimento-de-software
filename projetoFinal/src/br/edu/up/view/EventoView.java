package br.edu.up.view;

import java.util.List;

import br.edu.up.model.Evento;
import br.edu.up.controller.CategoriaEventoController;

public class EventoView 
{
	public static void imprimirEventos (List<Evento> eventos)
	{
		for (Evento evento : eventos)
		{
			System.out.println();
			System.out.println("------");
			System.out.println("ID: " + evento.getNome_evento());
		}	// Fim for	
	}	// Fim imprimirEventos
	
	public static void imprimir (Evento evento)
	{	
		String teste = CategoriaEventoController.localizar(evento.getId_categoria()).getNome_categoria();
		
		
		System.out.println("Nome: "+ evento.getNome_evento());

		System.out.println("Tipo do evento: " + teste);
	}
}	// Fim EventoView
