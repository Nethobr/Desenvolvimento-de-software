package br.edu.up;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		//Url onde o banco está, após o ...sqlite: ... é o diretório dele
		String url = "jdbc:sqlite:C:\\_src\\db\\hellow_word_sqlite.db";
		
		//Importando as classe de conexão e conectando pela string 'url'
		try {
			// Conexão
			Connection con = DriverManager.getConnection(url);
			
			Scanner input = new Scanner (System.in);
			
			System.out.print("Nome: ");
			String nomeP = input.nextLine();
			
			System.out.print("CPF: ");
			String cpfP = input.nextLine();
			
			System.out.print("DATA YYYY/MM/DD: ");
			String dataP = input.nextLine();
	
			// Ferramente que permite executar os comandos
					
				// Inserindo pessoas no banco de dados
				Statement insert = con.createStatement();
				String insertQuery = "INSERT INTO pessoas (nome, cpf, dt_nasc) VALUES ('"+ nomeP +"', '"+ cpfP +"', '"+ dataP +"')";
				insert.execute(insertQuery);
				
				// Atualizando no banco
				Statement update = con.createStatement();
				String updateQuery = "UPDATE pessoas SET nome = \"Mario Silva\" WHERE id = 3";
				update.executeUpdate(updateQuery);
				
				// Apagando no banco
				Statement delet = con.createStatement();
				String deletQuery = "DELETE FROM pessoas WHERE id = 3";
				delet.execute(deletQuery);
				
				// Fazendo um query
				Statement consulta = con.createStatement();
				String totalQuery = "Select * from pessoas";
				ResultSet resultado = consulta.executeQuery(totalQuery);
				
				input.close();
				
				// Imprimindo os dados
				while (resultado.next())
				{
					// o getTipoDado (index na tabela do banco)
					int id = resultado.getInt(1);
					String nome = resultado.getString(2);
					String cpf = resultado.getString(3);
					String data = resultado.getString(4);
					
					System.out.println("Id: " + id);
					System.out.println("Nome: " + nome);
					System.out.println("CPF: " + cpf);
					System.out.println("Data de nascimeno: " + data);
					System.out.println();
					
				}	// Fim while
		} catch (SQLException e) {
			// Tratamento de erro
			System.out.println("- > ERRO: Falha na conexão com o banco de dados!");
			System.out.println(e.getMessage());
		}	// Fim try & catch	
	}	// Fim método
}	// Fim Main