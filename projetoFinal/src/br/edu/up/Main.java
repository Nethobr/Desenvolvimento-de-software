package br.edu.up;

import java.util.List;

import br.edu.up.controller.EventoController;
import br.edu.up.model.Evento;
import br.edu.up.view.EventoView;

public class Main {

	public static void main(String[] args) {
//		
		Evento ev1 = new Evento ();
		ev1.setNome_evento("Teste2");
		ev1.setData_evento("07/06/2022");
		ev1.setDescricao_evento("SIIIIIIIIIIMMM.");
//		
		EventoController.salvarEvento(ev1);
		//mandamos buscar na base pela controller daí passando a lista para o "eventos"
//		Evento evento = EventoController.localizar(3);

		List<Evento> pessoas = EventoController.ListarEventos();
		EventoView.imprimirEventos(pessoas);

		
//		System.out.println(evento.getNome_evento());
//		EventoView.imprimir(evento);
		// exibimos a lista com a view, passando a função imprimir e a lista "eventos" pega na controller
//		EventoView.imprimirEventos(eventos);
		
	}	// fim método
}