package br.edu.up;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.up.model.Pessoa;

public class Programa {

	static EntityManagerFactory emf;
	static EntityManager em;

	public static void main(String[] args) 
	{
		emf = Persistence.createEntityManagerFactory("prj-jpa-sqlite");
		em = emf.createEntityManager();
		
		Pessoa pessoinha = new Pessoa ();
		
//		Inserindo
//		pessoinha.setNome("Geucimar");
//		pessoinha.setIdade(53);
//		salvar(pessoinha);
		
		
//		Atulizar
//	           objeto  localiza  ID do objeto
//		Pessoa julio = localizar (1);
//		julio.setIdade(20);
//  	Falando para atualizar
//		atualizar(julio);
		
		List<Pessoa> pessoas = listarPessoas();
		for (Pessoa pessoa : pessoas) 
		{
			System.out.println("-----------------------");
			System.out.println("ID: " + pessoa.getId() );
			System.out.println("Nome: " + pessoa.getNome() );
			System.out.println("Idade: " + pessoa.getIdade() );
		}
	}

	public static List<Pessoa> listarPessoas() 
	{
		List<Pessoa> pessoas = 
				em.createQuery("from Pessoa", Pessoa.class)
				.getResultList();
		return pessoas;
	}
	

	public static Integer salvar(Pessoa pessoa) 
	{
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		return pessoa.getId();
	}

	public static Pessoa localizar(Integer id) 
	{
		Pessoa pessoa = em.find(Pessoa.class, id);
		return pessoa;
	}
	

	public static void atualizar(Pessoa pessoa) 
	{
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
	}

	public static void apagar(Integer id) 
	{
		Pessoa pessoa = em.find(Pessoa.class, id);
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unused")
	private static void imprimir(Pessoa pessoa) 
	{
				System.out.println(pessoa);
    }
}