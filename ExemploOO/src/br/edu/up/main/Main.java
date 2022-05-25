package br.edu.up.main;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Animal;
import br.edu.up.model.Cachorro;
import br.edu.up.model.Homem;

public class Main {
	public static void main(String[] args) 
	{
//		List listaDeObjetos = new ArrayList();
		List <Animal> listaDeAnimais = new ArrayList();
		
			
		Animal objetoAnimal = new Animal();
		
		objetoAnimal.nome = "Romeu";
		objetoAnimal.genero = "Macho";
		objetoAnimal.porte = "Pequeno";
		
		
		Cachorro objetoCachorro1 = new Cachorro();
		
		objetoCachorro1.genero = "Macho";
		objetoCachorro1.nome = "Scoobe";
		objetoCachorro1.porte = "Grande";
		try {
			objetoCachorro1.setIdade(3);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
		}
		listaDeAnimais.add(objetoCachorro1);
		
		Cachorro objetoCachorro2 = new Cachorro();
		
		objetoCachorro2.genero = "Macho";
		objetoCachorro2.nome = "Jonny";
		objetoCachorro2.porte = "Pequeno";
		try {
			objetoCachorro2.setIdade(8);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
		}
		listaDeAnimais.add(objetoCachorro2);
		
		Cachorro objetoCachorro3 = new Cachorro();
		
		objetoCachorro3.genero = "Macho";
		objetoCachorro3.nome = "Zeus";
		objetoCachorro3.porte = "Grande";
		try {
			objetoCachorro3.setIdade(3);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
		}
		listaDeAnimais.add(objetoCachorro3);
		
		Homem objetoHomem = new Homem ();
		objetoHomem.nome = "Jorge";
		objetoHomem.porte = "Médio";
		try {
			objetoHomem.setIdade(25);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
		}
		listaDeAnimais.add(objetoHomem);
		
		for (Animal animal : listaDeAnimais) 
		{
			System.out.println("Nome: " + animal.nome);
			System.out.println("Idade: " + animal.getIdade());
			System.out.println();
		}	//End - for
	}	//End - método
}	//End - Main