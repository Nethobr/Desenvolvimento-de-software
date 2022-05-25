package br.edu.up;

public class Aluno 
{
	//Atributos
	public String nome;
	public String matricula;
	public double nota;
	
	//Var's
	double 	media = 0, fakeNota = 0;
	
	public double maiorNota, menorNota;
	
	public int 	aprov = 0, reprov = 0;

	//Métodos

	//Método que gera a média e a manda
	public double getMedia ( int qtdAlunos )
	{
		return (media / qtdAlunos);
	}	//Fim getMedia
	
	//Soma a média de todos os alunos
	public void somaMedia ( double x )
	{
		this.media = x + media;
	}	//Fim somaMedia
	
	//Método que vefirica a aprovação do aluno e conta
	public void verifAprov ( double nota )
	{
		if (nota >= 6)
			aprov ++;
		else
			reprov ++;
	}	//Fim verifAprov
	
	//Método que guarda a maior e a menor nota
	public void guardaNotas ( double nota )
	{
		if (nota > maiorNota)
			maiorNota = nota;
		else if (nota < menorNota || nota == 0)
			menorNota = nota;
	}	//Fim guardaNotas 	
}	//Fim Aluno