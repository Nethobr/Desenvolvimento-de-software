package netho.br.pacote;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
public class Main 
{
	public static void main(String[ ] args) throws IOException 
	{
		//Gerenciamento do arquivo
		File arquivo = new File ("C:\\Users\\Aluno\\Downloads\\grupos-tabulados.txt");
		Formatter gravador = new Formatter("C:\\Users\\Aluno\\Downloads\\numeros.txt");
		
		Scanner input = new Scanner (arquivo);
		input.nextLine();

		//Objeto para o grupo
		Grupo [] grupo = new Grupo [6];
		
		//Testes e variáveis
		int qtd = 0;
		int count = 0;
		int countTwo = 0;
		int soma = 0;
		String let = "";
		int somaTotal = 0;
		
		while (input.hasNext())
		{
			String linha = input.nextLine();

			String [] dadosLinha = linha.split("	");
			String letra = dadosLinha [0];
			int numLetra = Integer.parseInt(dadosLinha[1]);
			
			if (countTwo < 11 || qtd == 71)
			{
				soma += numLetra;
				let = letra;
			}	//Fim if
			
			if (countTwo > 11 || qtd == 71)
			{	
				//Injetando os dados no vetor do objeto grupo
				Grupo novoGrupo = new Grupo ();
				
				novoGrupo.letra = let;
				novoGrupo.somaGrupo = soma;
				grupo[count] = novoGrupo;

				countTwo = 0;
				soma = numLetra;
				count++;
			}	//Fim if

			//Soma
			countTwo ++;
			qtd ++;
			somaTotal += numLetra;
		}	//Fim While
		
		//GRAVANDO OS ARQUIVOS
		gravador.format("Total de registro: "+ count +" | ");
		for (Grupo grupo2 : grupo) 
		{
			gravador.format("Grupo: "+ grupo2.letra +" - "+"Soma do grupo: "+ grupo2.somaGrupo +" | ");
			System.out.println();
		}	//Fim for	
		gravador.format("Total: "+ somaTotal);

		//Fechando
		gravador.close();
		input.close();
	}
}