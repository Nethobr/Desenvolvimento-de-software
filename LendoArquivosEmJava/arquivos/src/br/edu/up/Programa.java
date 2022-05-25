package br.edu.up;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		//Criando um objeto para a URL do arquivo
		File arquivo = new File ("C:\\Users\\Alexandre\\Downloads\\alunos.csv");
		
		//Criando um objeto para identificar a quantidades de alunos
		Scanner quantidade = new Scanner (arquivo);
		quantidade.nextLine();
		//Criando o loop e o contador para os alunos
		int qtdAlunos = 0;
		while (quantidade.hasNext()) 
		{ 
			quantidade.nextLine(); 
			qtdAlunos ++; 
		}	//Fim wilhe
		quantidade.close();
		
		//Falando para o Scanner ler o objeto "arquivo"
		Scanner leitor = new Scanner (arquivo);
		//descarta primeira linha da leitura do aquivo
		leitor.nextLine();	
		
		//Criamos um vetor para o objeto de alunos
		Aluno[] alunos = new Aluno [qtdAlunos];
		
		int count = 0;
		while (leitor.hasNext())
		{
			//Lê a linha do arquivo
			String linha = leitor.nextLine();
			
			//Corta no ;
			String[] dadosLinha = linha.split(";");
			String matricula = dadosLinha[0];
			String nome = dadosLinha [1];
			//Como double não aceita "," dou um replace para "."
			double nota = Double.parseDouble(dadosLinha[2].replace(",", "."));
			
			//Crio um objeto chamado novoAluno para passas os valores da linha
			Aluno novoAluno = new Aluno ();
			novoAluno.nome = nome;
			novoAluno.matricula = matricula;
			novoAluno.nota = nota;
			
			//Passo para o vetor do objeto alunos, o valor do objeto novoAluno
			alunos[count] = novoAluno;
			
			count++;
		}	//Fim while
		
		//Criando um objeto para a notaFinal
		Aluno nota = new Aluno ();
		
		for (int i = 0; i < alunos.length; i++)
		{
			Aluno a = alunos[i];
			
			System.out.println("Nome: "+a.nome+"\nMatricula: "+a.matricula+"\nNota: "+a.nota);
			System.out.println("-------------------");
			
			nota.guardaNotas(a.nota);
			nota.verifAprov(a.nota);
			nota.somaMedia(a.nota);
		}	//Fim for
		
		System.out.println("Quantidade de alunos: "+ qtdAlunos);
		System.out.println("Aprovado: "+ nota.aprov +" - "+"Reprovados: "+ nota.reprov);
		System.out.println("Média final da turma: "+ nota.getMedia(qtdAlunos));
		System.out.println("Maior nota: "+ nota.maiorNota +" - "+"Menor nota: " +nota.menorNota);
		
		leitor.close();
	}	//Fim método main
}	//Fim programa