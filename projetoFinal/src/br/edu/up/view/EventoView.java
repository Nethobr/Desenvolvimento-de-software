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
			CategoriaEvento cat = CategoriaEventoController.localizar(evento.getId_categoria());
			System.out.println("- Nome: " + evento.getNome_evento() + " (" + evento.getId() + ").");
			System.out.println("- Descrição: " + evento.getDescricao_evento());
			System.out.println("- Categoria: " + cat.getNome_categoria());
			System.out.println("- Data: " + evento.getData_evento());
		}	// Fim for	
	}	// Fim imprimirEventos
	
	public static void imprimirEventoNome ()
	{
		// Objetos
		Scanner input = new Scanner (System.in); 
		Evento atualEvento = new Evento();
		
		// Início
		System.out.print("Informe o nomme do evento: ");
		String nome = input.next();
		
		List<Evento> eventos = EventoController.localizarNome(nome);
		
		if (eventos.isEmpty())
		{
			System.out.println("O evento " + nome + " não está cadastrado.");
		} 
		else
		{
			for (Evento evn : eventos)
			{	
				System.out.println();
				CategoriaEvento cat = CategoriaEventoController.localizar(evn.getId_categoria());
				System.out.println("- Nome: " + evn.getNome_evento() + " (" + evn.getId() + ").");
				System.out.println("- Descrição: " + evn.getDescricao_evento());
				System.out.println("- Categoria: " + cat.getNome_categoria());
				System.out.println("- Data: " + evn.getData_evento());
				System.out.println();
				atualEvento = evn;
			}	// Fim for
			MainView.crudOp(atualEvento.getId());
		}
		input.close();
	}	// Fim imprimirEventoNome
		
	public static void imprimirCategoria (List<CategoriaEvento> categorias) 
	{
		for (CategoriaEvento categoria : categorias)
		{
			System.out.println("	(" + categoria.getId_cat() + ") -> " + categoria.getNome_categoria() + ".");
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
		int count = 0;
		do
		{
			Evento evn = new Evento ();
			
			System.out.print("Informe o nome do evento: ");
			evn.setNome_evento(input.nextLine());
			
			System.out.print("Descrição do evento: ");
			evn.setDescricao_evento(input.nextLine());
			
			System.out.println("Digite o ID da categoria");
			imprimirCategoria(categorias);
			evn.setId_categoria(input.nextInt());
			
			System.out.print("Informe a data do evento DD/MM/AAAA:");
			evn.setData_evento(input.nextLine());
			
			input.nextLine();
			
			EventoController.salvarEvento(evn);
			System.out.print("Desenha continuar? (1 = CONTINUAR): ");
			int temp = input.nextInt();
			if (temp != 1)
			{
				if (count > 0)
					System.out.println("Cadastros realizados com sucesso!");
				else
					System.out.println("Cadastro realizado com sucesso!");
				keep = 1;
			}
			else
			{
				count ++;
				keep = 0;
			}
			input.nextLine();
		} while (keep == 0);
		input.close();
	}	// Fim menuCadastroEventos

	public static void menuAtualizar(Evento evento)
	{
		Scanner in = new Scanner(System.in);
		Evento newEvento = new Evento();
		CategoriaEvento cat = CategoriaEventoController.localizar(evento.getId_categoria());
		
		System.out.print("Novo nome (" +evento.getNome_evento() + "): ");
		String nome = in.next();
		System.out.print("Descrição: ");
		String desc = in.next();
		System.out.print("Categoria (" + cat.getNome_categoria() + "): ");
		Integer catE = in.nextInt();
		System.out.print("Data (" + evento.getData_evento() + "): ");
		String data = in.next();
		
		newEvento.setId(evento.getId());
		
		if (nome != null)
			newEvento.setNome_evento(nome);
		if (desc != null)
			newEvento.setDescricao_evento(desc);
		if (catE != null)
			newEvento.setId_categoria(catE);
		if (data != null)
			newEvento.setData_evento(data);
		
		if (MainView.trueDecision() == "SIM")
		{
			EventoController.atualizarEvento(newEvento);
			System.out.println("Operação realizada com sucesso!");
		}
		else
			System.out.println("Operação cancelada!");
	
		in.close();
	}	// Fim menuAtualizar
}	// Fim EventoView
