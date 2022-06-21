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
		
		System.out.println("-----------------------------------------");
		System.out.println("Quais operações deseja realizar");
		System.out.println();
		System.out.println("1 - Imprimir todos os eventos.");
		System.out.println("2 - Selecionar evento por nome.");
		System.out.println("3 - Selecionar eventos por categoria.");
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

		List<CategoriaEvento> cat = CategoriaEventoController.ListarCategorias();
		Evento evento = EventoController.localizar(id);
		
		System.out.println("-----------------------------------------");
		System.out.println("Qual operação crud deseja realizar?");
		System.out.println();
		System.out.println("1 - Inserir novo evento.");
		System.out.println("2 - Atualizar evento atual.");
		System.out.println("3 - Deletar evento atual.");
		System.out.println("4 - Sair.");

		
		int keep = 0;
		do
		{
			Scanner in = new Scanner (System.in);
			op = in.nextInt();
			System.out.println();
			System.out.println("-----------------------------------------");
			System.out.println();
			switch (op)
			{
				case 1:
					EventoView.menuCadastroEventos(cat);
					keep = 1;
					break;
				case 2:
					EventoView.menuAtualizar(evento);
					keep = 1;
					break;
				case 3:
					EventoView.menuDeletar(evento);
					keep = 1;
					break;
				case 4:
					System.out.println("Saindo das opções de crud.");
					keep = 1;
					break;
				default:
					System.out.println("Opção não registrada no sistema.");
					keep = 0;
			}	// Fim switch
			
			keepProgram();
			in.close();
		} while (keep != 1);
	}	//Fim crudOp
	
	public static String trueDecision()
	{
		Scanner in = new Scanner(System.in);
		String res = "";
		int keep = 1;
		
		System.out.println("-----------------------------------------");
		
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
			
		return res;
	}	// Fim trueDecision
	
	public static void keepProgram ()
	{
		Scanner input = new Scanner (System.in);
		int op;
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("Deseja realizar mais operações (1 = SIM)?");
		op = input.nextInt();

		switch (op)
		{
			case 1:
				oqueDeseja();
			default:
				System.out.println("Fim do programa.");
		}	// Fim switch		
		input.close();
	}	// Fim keepProgram
}
