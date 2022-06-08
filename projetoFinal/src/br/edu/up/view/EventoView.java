package br.edu.up.view;

import java.util.List;
import br.edu.up.model.Evento;

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
		System.out.println("Nome: "+ evento.getNome_evento());
	}
}	// Fim EventoView
