package br.com.fiap.aula8.roteiro4_2;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.aula8.roteiro4_2.Helper.VendasHelper;
import br.com.fiap.aula8.roteiro4_2.entity.Cliente;
import br.com.fiap.aula8.roteiro4_2.entity.Endereco;
import br.com.fiap.aula8.roteiro4_2.entity.Item;
import br.com.fiap.aula8.roteiro4_2.entity.Pedido;
import br.com.fiap.aula8.roteiro4_2.pk.PedidosPK;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SCJ Persist�ncia Roteiro 5 JPA");
		EntityManager em = emf.createEntityManager();
		VendasHelper dao = new VendasHelper(em);

		try {
			//Definindo o cliente
			Cliente cliente = new Cliente(); 
			cliente.setId(10); 
//			cliente.setStatus(StatusCliente.ATIVO);
			cliente.setEmpresa("Fiap");
			
			//Definindo o Endereco
			Endereco endereco = new Endereco(); 
			endereco.setRua("Lins de Vasconcelos");
			endereco.setCidade("S�o Paulo"); 
			endereco.setCep("01538-001");
			endereco.setCliente(cliente);
			
			//Defnindo o pedido
			PedidosPK pkpedido = new PedidosPK(); 
			pkpedido.setCodigo(100); 
			pkpedido.setCategoria("Livros");
			
			Pedido pedido = new Pedido(); 
			pedido.setDataPedido(new Date()); 
			pedido.setPedidoPK(pkpedido); 
			pedido.setCliente(cliente);
			
			//Definindo dois itens
			Item item1 = new Item();
			item1.setQuantidade(2);
			item1.setPedido(pedido);
			
			Item item2 = new Item(); 
			item2.setQuantidade(3);
			item2.setPedido(pedido);
			
			//Fazendo as associações
			pedido.getItens().add(item1); 
			pedido.getItens().add(item2);
			
			cliente.getEnderecos().add(endereco); 
			cliente.getPedidos().add(pedido);
			
			dao.salvar(cliente);
			
			System.out.println("Cliente inclu�do com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
