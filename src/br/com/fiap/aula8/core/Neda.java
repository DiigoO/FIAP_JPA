package br.com.fiap.aula8.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula8.entity.Forum;
import br.com.fiap.aula8.entity.Usuario;

/**
 * NEDA-SUA-CONTA -'-
 * @author no-tin...
 *
 */
public class Neda {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistencia_Roteiro4_JPA");
		EntityManager em = entityManagerFactory.createEntityManager();
		ForumHelper fHelper = new ForumHelper(em);
		
		Forum forum = new Forum();
		forum.setAssunto("Java Persistence");
		forum.setDescricao("Discussão de JPA");
		
		Usuario user = new Usuario();
		user.setEmail("gui@gmail.com");
		user.setForum(forum);
		user.setNome("Guilerme");
		
		System.out.println(fHelper.salvar(forum));
		System.out.println(fHelper.adicionarUsuario(1, user));
		
		

	}

}
