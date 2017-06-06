package br.com.fiap.aula9;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula9.Entity.Funcionario;
import br.com.fiap.aula9.Entity.Tarefa;
import br.com.fiap.aula9.Helper.Helper;

public class Teste {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia_Roteiro4_JPA");
		EntityManager em = emf.createEntityManager();
		incluirFuncionario(em);
		listarFuncionarios(em);
		buscarFuncionario(em, "2000");
		
	}
	private static void incluirFuncionario(EntityManager em){
		Helper dao = new Helper(em);
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula("2000");
		funcionario.setNome("Alberto Santos");
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Teste Unita?rio");
		tarefa.setDuracao(100);
		tarefa.getFuncionarios().add(funcionario);
		funcionario.getTarefas().add(tarefa);
		try {
			dao.salvar(funcionario);
			System.out.println("Funcionario OK");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	private static void listarFuncionarios(EntityManager em){
		Helper dao = new Helper(em);
		List<Funcionario> funcionarios = dao.listarTodos();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getMatricula() + ": " +
					funcionario.getNome());
		}
		em.close();
	}
	private static void buscarFuncionario(EntityManager em, String
			matricula){
		Helper dao = new Helper(em);
		Funcionario f = dao.buscarFuncionario(matricula);
		System.out.println(f.getMatricula() + ": " + f.getNome());
	}
}