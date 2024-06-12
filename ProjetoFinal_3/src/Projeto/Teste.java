package Projeto;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int escolha = 0;
        GereResiduos gestor = new GereResiduos();
        Cliente cliente = new Cliente("André", "303566553ZX2", "andre@upt.pt", 916565565); //Exemplo usando os atributos da classe Cliente
        
        do {
            
        	System.out.println("Selecione uma opção:");
            System.out.println("1 - Diretor");
            System.out.println("2 - Cliente");
            System.out.println("3 - Sair");
            escolha = ler.nextInt();
           
            if (escolha == 1) {
                System.out.println("Escolheu ser Diretor de Resíduos.");
                int opcao = 0;
                do {
                    System.out.println("----- Menu Diretor de Resíduos -----");
                    System.out.println("1. Consultar clientes");
                    System.out.println("2. Adicionar Coleta");
                    System.out.println("3. Ver as mensagens do cliente (Suporte)");
                    System.out.println("4. Enviar mensagens ao cliente (Suporte)");
                    System.out.println("5. Sair do menu de Diretor de Resíduos");
                    opcao = ler.nextInt();

                    switch (opcao) {
                        case 1:
                            gestor.consultarClientesRegistrados();
                            break;
                        case 2:
                            System.out.println("Digite a data da coleta:");
                            String dataColeta = ler.next();
                            System.out.println("Digite a hora da coleta:");
                            String horaColeta = ler.next();
                            System.out.println("Digite a localização da coleta:");
                            ler.nextLine();
                            String localizacaoColeta = ler.nextLine();
                            Coletas coleta = new Coletas(dataColeta, horaColeta, localizacaoColeta);
                            gestor.adicionarColetas(dataColeta, horaColeta, localizacaoColeta);                            
                            break;
                        case 3:
                            gestor.mostrarMensagens();
                            break;
                        case 4:
                        	System.out.println("Qual o email do cliente a que pretende enviar uma mensagem?");
                        	String mail = ler.next();
                        	Cliente clienteEncontrado = gestor.pesquisarClientes(mail);
                        	if(clienteEncontrado != null) {
                        		System.out.println("CC do cliente: " + clienteEncontrado.getCC());
                        		System.out.println("Digite a mensagem para o cliente:");
                        		ler.nextLine();
                                String mensagemD = ler.nextLine();
                                gestor.responderMensagemCliente(mail, mensagemD);
                        	}                        
                            break;
                        case 5:
                            System.out.println("A sair do menu diretor... ");
                            break;
                    }
                } while (opcao != 5);
            } else if (escolha == 2) {
                System.out.println("Escolheu ser Cliente.");
                int opcao = 0;
                do {
                    System.out.println("----- Menu de Cliente -----");
                    System.out.println("1. Registrar cliente");
                    System.out.println("2. Registrar resíduos");
                    System.out.println("3. Consultar coletas");
                    System.out.println("4. Acessar ao relatório");
                    System.out.println("5. Enviar mensagem ao diretor (Suporte)");
                    System.out.println("6. Ver mensagens do diretor (Suporte)");
                    System.out.println("7. Ver o ranking de reciclagem");
                    System.out.println("8. Ver informações relativamente a residuos");
                    System.out.println("9. Sair do menu cliente");
                    opcao = ler.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.println("Qual o nome?");
                            ler.nextLine();
                            String nome = ler.nextLine();
                            String CC;
                            while (true) {
                                System.out.println("Qual o nº do cartão de cidadão?");
                                CC = ler.next();
                                if (gestor.ccJaExiste(CC)) {
                                    System.out.println("Nº CC já existe! Tente novamente.");
                                } else {
                                    break;
                                }
                            }
                            String mail;
                            while (true) {
                                System.out.println("Qual o email do cliente?");
                                mail = ler.next();
                                if (gestor.emailJaExiste(mail)) {
                                    System.out.println("Email já existe! Tente novamente.");
                                } else {
                                    break;
                                }
                            }
                            int numeroTele;
                            while (true) {
                                System.out.println("Qual o nº de telefone do cliente?");
                                numeroTele = ler.nextInt();
                                if (gestor.numTelefJaExiste(numeroTele)) {
                                    System.out.println("Email já existe! Tente novamente.");
                                } else {
                                    break;
                                }
                            }
                            gestor.registrarCliente(nome, CC, mail, numeroTele);
                            break;
                        case 2:
                        	System.out.println("Qual o email do cliente que pretende registar residuos?");
                        	mail = ler.next();
                        	if(gestor.pesquisarClientes(mail) != null) {
                        		System.out.println("Introduza o tipo de resíduo");
                                ler.nextLine();
                                String tipoResiduo = ler.nextLine();
                                System.out.println("Introduza a quantidade:");
                                double quantResiduo = ler.nextDouble();
                                gestor.registarResiduos(mail, tipoResiduo, quantResiduo);
                        	}                        	
                            break;
                        case 3:
                            gestor.consultarColetas();
                            break;
                        case 4:
                        	System.out.println("Qual o email do cliente que pretende ver o relatório de resíduos?");
                        	mail = ler.next();                       	
                            cliente = gestor.pesquisarClientes(mail);
                            if (cliente != null) {
                                cliente.acederRelatorio(); 
                            } else {
                                System.out.println("Cliente não encontrado!");
                            }
                            break;
                        case 5:
                            System.out.println("Digite o seu email:");
                            ler.nextLine();
                            mail = ler.nextLine();
                            Cliente clienteEncontrado = gestor.pesquisarClientes(mail);
                        	if(clienteEncontrado != null) {  
                            	System.out.println("Nome do cliente:" + clienteEncontrado.getNome());                             
                                System.out.println("Número do CC:" + clienteEncontrado.getCC());
                                System.out.println("Digite a mensagem:");
                                String mensagemC = ler.nextLine();
                                gestor.enviarMensagemCliente(mail,clienteEncontrado.getNome(), clienteEncontrado.getCC(), mensagemC);
                            }
                            break;
                        case 6:
                            gestor.receberRespostaDiretor();   
                            break;
                        case 7:
                            gestor.mostrarRankingCliente();
                            break;
                        case 8:
                            cliente.imprimirEcopontoAmarelo();
                            cliente.imprimirEcopontoAzul();
                            cliente.imprimirEcopontoVerde();
                            cliente.imprimirResiduosEspeciais();
                            break;
                        case 9:
                            System.out.println("A sair do menu cliente...");
                            break;
                    }
                } while (opcao != 9);
            } else if (escolha == 3) {
                System.out.println("A sair...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 3);

        ler.close();
    }
}
