package br.com.fiap.aula8.roteiro4_2.Helper;

import javax.persistence.EntityManager;

import br.com.fiap.aula8.roteiro4_2.entity.Cliente;

public class VendasHelper {
	private EntityManager em;

	public VendasHelper(EntityManager em){
		this.em = em;
	}
	public void salvar(Cliente cliente) throws Exception{ 
		try {
			em.getTransaction().begin(); 
			em.persist(cliente); 
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback(); 
			throw e;
		} 
	}
}