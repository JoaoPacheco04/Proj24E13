package Projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GereResiduos {
	private ArrayList<Cliente> clientes;
	private ArrayList<Coletas> coletas;
	private ArrayList<Mensagem> mensagens;
	private double totalResiduos;

	public GereResiduos() {
		this.clientes = new ArrayList<>();
		this.coletas = new ArrayList<>();
		this.mensagens = new ArrayList<>();
		totalResiduos = 0.0;
	}
	
	//método para registrar cliente               
	
	 public void registrarCliente(String nome, String CC, String mail, int numeroTelefone) {
	    	Cliente novoCliente = new Cliente(nome, CC, mail, numeroTelefone);
	    	clientes.add(novoCliente);
	 }
	   
	 //métodos para não se registarem clientes com o mesmo email/nºCC/nº telefone
	 
	 public boolean emailJaExiste(String email) {
		 for(Cliente cliente : clientes) {
			 if(cliente.getMail().equals(email)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public boolean ccJaExiste(String cc) {
		 for(Cliente cliente : clientes) {
			 if(cliente.getCC().equals(cc)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public boolean numTelefJaExiste(int numTelef) {
		 for(Cliente cliente : clientes) {
			 if(cliente.getNumeroTelefone() == (numTelef)) {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 //método para pesquisar um dado cliente          está direito

	 public Cliente pesquisarClientes(String emailCli) {
		 for(Cliente cliente : clientes) {
			 if(cliente.getMail().equalsIgnoreCase(emailCli)) {
				 System.out.println("Cliente encontrado com o email:" + cliente.getMail());
				 return cliente;
			 }
		 }
		 System.out.println("Cliente não registado!!!");
		 return null;
	 }
     
	 //método para registrar resíduos
	 
	 public void registarResiduos(String mail, String tipoResiduo, double quantResiduos) {
    	 Relatorio relatorio = new Relatorio(tipoResiduo, quantResiduos);
    	 Cliente cli = pesquisarClientes(mail);
    	 if(cli != null) {
    		 cli.registarResiduos(relatorio);
    	 }
    		 
	 }
	 
	 //método para adicionar uma coleta 
	 
	  public void adicionarColetas(String data, String hora, String localizacao) {
	        Coletas novaColeta = new Coletas(data, hora, localizacao);
	        coletas.add(novaColeta);
	  }
	    
	  //método para consultar as coletas       
	  
	  public void consultarColetas() {
	        for (Coletas coleta : coletas) {
	            System.out.println(coleta.toString());
	        }
	  }

	  //método para receber uma resposta do diretor
	  
	  public void receberRespostaDiretor() {
	    	for(Mensagem mensagem : mensagens) {
	    		System.out.println("Resposta do diretor: " + mensagem.getResposta());
	    	}
	  }
	
	  //método para consultar os clientes registados     
	  
	  public void consultarClientesRegistrados() {
	        System.out.println("Clientes Registrados:");
	        for (Cliente cliente : clientes) {
	            System.out.println("Nome: " + cliente.getNome());
	            System.out.println("CC: " + cliente.getCC());
	            System.out.println("Email: " + cliente.getMail());
	            System.out.println("Telefone: " + cliente.getNumeroTelefone());
	            System.out.println();
	        }
	  }

	//método para enviar mensagem por parte do cliente
	  
	  public void enviarMensagemCliente(String mail, String nome, String cc,String mensagemCliente) {
	        Mensagem novaMensagem = new Mensagem(mail,nome,cc, mensagemCliente);
	        mensagens.add(novaMensagem);
	        System.out.println("Mensagem enviada por " + novaMensagem.getNomeCliente() + " (CC: " + novaMensagem.getCCCliente() + "): " + mensagemCliente);
	  }

	  //método para mostrar mensagens 
	  
	  public void mostrarMensagens() {
	        System.out.println("Mensagens Recebidas:");
	        for (Mensagem mensagem : mensagens) {
	            System.out.println("Nome cliente: " + mensagem.getNomeCliente());
	            System.out.println("CC cliente: " + mensagem.getCCCliente());
	            System.out.println("Email cliente: " + mensagem.getMailCliente());
	            System.out.println("Mensagem: " + mensagem.getMensagemCliente());
	            if (mensagem.getResposta() != null) {
	                System.out.println("Resposta: " + mensagem.getResposta());
	            }
	            System.out.println();
	        }
	  }

	  //método para responder a uma mensagem do cliente
	  
	  public void responderMensagemCliente(String mail, String resposta) {
		  boolean mensagemEncontrada = false;
		    for (Mensagem mensagem : mensagens) {
		        if (mensagem.getMailCliente().equals(mail)) {
		            mensagem.setResposta(resposta);
		            System.out.println("Resposta enviada para " + mensagem.getNomeCliente() + " (CC: " + mensagem.getCCCliente() + "): " + resposta);
		            mensagemEncontrada = true;
		            break;
		        }
		    }
		    if (!mensagemEncontrada) {
		        System.out.println("Mensagem não encontrada para o cliente com email " + mail);
		    }
		}

	  //método para mostrar ranking dos clientes que mais reciclaram
	  
	  public void mostrarRankingCliente() {
		  if (!clientes.isEmpty()) {
	            Collections.sort(clientes, new Comparator<Cliente>() {
	                @Override
	                public int compare(Cliente c1, Cliente c2) {
	                    return Double.compare(c2.getTotalResiduos(), c1.getTotalResiduos());
	                }
	            });
	            System.out.println("Ranking de reciclagem:");
	            for (Cliente cliente : clientes) {
	                System.out.println(cliente.getNome() + ": " + cliente.getTotalResiduos() + " kg");
	            }
	        } else {
	            System.out.println("Nenhum cliente registrado.");
	        }
	  }
	  
}
