package br.edu.up.model;

public class Animal {
	public String nome;
	public String porte;
	public String genero;
	
	//De 1 a 150
	private int idade;
	public void setIdade(int idade) throws Exception{
		if (idade > 0 && idade < 150)
			this.idade = idade;
		else
			throw new Exception("Idade inválida!");
	}
	public int getIdade() {
		return idade;
	}

}	//End - Animal
