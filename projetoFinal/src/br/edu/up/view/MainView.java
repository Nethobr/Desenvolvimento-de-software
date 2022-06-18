package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.controller.EventoController;
import br.edu.up.model.Evento;

public class MainView 
{
	public static void oqueDeseja ()
	{
		// Operador
		int op;
		
		// Objetos
		List<Evento> eventos = EventoController.ListarEventos();
		Scanner input = new Scanner (System.in);
		
		System.out.println("Quais operações deseja realizar: ");
		System.out.println("	1 - Imprimir todos os eventos.");
		System.out.println("	2 - Selecionar evento por nome.");
		System.out.println("	3 - Selecionar eventos por data.");
		System.out.println("	4 - Selecionar eventos po categoria.");
		System.out.println();
		System.out.print("Informe atrávés de seu número qual deseja: ");
		op = input.nextInt();
		
		switch (op)
		{
			case 1:
				EventoView.imprimirEventos(eventos);
				break;
			
			case 2:
				EventoView.imprimirEventoNome();
				break;
				
			default:
				System.out.println("Valor inválido!");
		}	// Fim switch
		
		input.close();
	}	// Fim oqueDeseja
}
