package br.edu.up.view;

import java.util.List;
import java.util.Scanner;

import br.edu.up.controller.CategoriaEventoController;
import br.edu.up.controller.EventoController;
import br.edu.up.model.CategoriaEvento;
import br.edu.up.model.Evento;

public class MainView 
{
	@SuppressWarnings("unused")
	public static void oqueDeseja ()
	{
		// Operador
		int op;
		
		// Objetos
		List<Evento> eventos = EventoController.ListarEventos();
		List<CategoriaEvento> cats = CategoriaEventoController.ListarCategorias();
		Scanner input = new Scanner (System.in);
		
		System.out.println("Quais operações deseja realizar");
		System.out.println();
		System.out.println("1 - Imprimir todos os eventos.");
		System.out.println("2 - Selecionar evento por nome.");
		System.out.println("3 - Selecionar eventos po categoria.");
		System.out.println("4 - Inserir evento.");
		System.out.println();
		System.out.print("Informe atrávés de seu número qual deseja: ");
		op = input.nextInt();
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println();
		
		switch (op)
		{
			case 1:
				EventoView.imprimirEventos(eventos);
				break;
			
			case 2:
				EventoView.imprimirEventoNome();
				break;
			
			case 3:
				EventoView.imprimirPorCategorias();
				break;
				
			case 4:
				EventoView.menuCadastroEventos(cats);
				break;
				
			default:
				System.out.println("Valor inválido!");
		}	// Fim switch
		
		input.close();
	}	// Fim oqueDeseja
	
	public static void crudOp (Integer id)
	{
		// Operado
		int op;
		
		// Objetos
		Scanner in = new Scanner (System.in);
		List<CategoriaEvento> cat = CategoriaEventoController.ListarCategorias();
		Evento evento = EventoController.localizar(id);
		
		System.out.println("Qual operação crud deseja realizar?");
		System.out.println();
		System.out.println("1 - Inserir novo evento.");
		System.out.println("2 - Atualizar evento atual.");
		System.out.println("3 - Deletar evento atual.");
		op = in.nextInt();
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println();
		
		switch (op)
		{
			case 1:
				EventoView.menuCadastroEventos(cat);
				break;
			case 2:
				EventoView.menuAtualizar(evento);
				break;
			case 3:
				EventoView.menuDeletar(evento);
				break;
				
			default:
				System.out.println("Opção não registrada no sistema.");
		}	// Fim switch	
		
		in.close();
	}	//Fim crudOp
	
	public static String trueDecision()
	{
		Scanner in = new Scanner(System.in);
		String res = "";
		int keep = 1;
			
		do
		{
			System.out.println();
			System.out.println("Realmente deseja fazer está operação?");
			System.out.println("1 - SIM | 0 - NÃO");
			int deci = in.nextInt();
			
			switch (deci)
			{
				case 0:
					res = "NAO";
					keep = 0;
					break;
					
				case 1:
					res = "SIM";
					keep = 0;
					break;
					
				default:
					System.out.println("Operador inválido.");
					keep = 1;
			}
		}	while (keep != 0);	
		
		in.close();
		
		return res;
	}	// Fim trueDecision
}
