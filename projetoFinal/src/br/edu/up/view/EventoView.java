package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.model.Evento;
import br.edu.up.model.CategoriaEvento;
import br.edu.up.controller.CategoriaEventoController;
import br.edu.up.controller.EventoController;

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
	
	public static void imprimirCategoria (List<CategoriaEvento> categorias) 
	{
		for (CategoriaEvento categoria : categorias)
		{
			System.out.println("Nome: " + categoria.getNome_categoria() + " (" + categoria.getId_cat() + ")");
		}	// Fim for
	}	// Fim imprimirCategoria
	
	public static void imprimir (Evento evento)
	{	
		String teste = CategoriaEventoController.localizar(evento.getId_categoria()).getNome_categoria();
		
		
		System.out.println("Nome: "+ evento.getNome_evento());

		System.out.println("Tipo do evento: " + teste);
	}	// Fim imprimir
	

	public static void menuCadastroEventos(List<CategoriaEvento> categorias)
	{	
		Scanner input = new Scanner (System.in);
		int keep = 0;
		do
		{
			Evento evn = new Evento ();
			System.out.print("Informe o nome do evento: ");
			evn.setNome_evento(input.next());
			System.out.print("Descri��o para o evento: ");
			evn.setDescricao_evento(input.next());
			System.out.println("Digite o ID da categoria");
			imprimirCategoria(categorias);
			evn.setId_categoria(input.nextInt());
			EventoController.salvarEvento(evn);

		} while (keep != 0);
		input.close();
	}	// Fim menuCadastroEventos
}	// Fim EventoView
