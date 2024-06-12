package Projeto;
import java.util.ArrayList;

public class Cliente {
    private ArrayList<Relatorio> relatorios;
	private String nome;
    private String CC;
    private String mail;
    private int numeroTelefone;
    private double totalResiduos;
   
    public Cliente(String nome, String CC, String mail, int numeroTelefone) {
        this.nome = nome;
        this.CC = CC;
        this.mail = mail;
        this.numeroTelefone = numeroTelefone;
        this.totalResiduos = 0.0;
        this.relatorios = new ArrayList<>();
        }

    public String getNome() {
        return nome;
    }

    public String getCC() {
        return CC;
    }

    public String getMail() {
        return mail;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public double getTotalResiduos() {
    	return totalResiduos;
    }
    
    //método para o cliente registrar os resíduos que pretende reciclar
    
    public void registarResiduos(Relatorio relatorio) {
    	 relatorios.add(relatorio);
	     totalResiduos += relatorio.getQuant();
    }
    
    //método para o cliente aceder ao seu relatório de resíduos
    
    public void acederRelatorio() {
        for (Relatorio relatorio : relatorios) {
            System.out.println(relatorio.toString());
        }
    }
    public void imprimirEcopontoAmarelo() {
		System.out.println("Ecoponto amarelo (Plástico e Metal):");
		System.out.println("Latas de bebidas");
		System.out.println("Latas de conserva");
		System.out.println("Pacotes de leite e bebidas");
		System.out.println("Iogurtes");
		System.out.println("Tabuleiros de alumínio");
		System.out.println("Garrafas, garrafões e frascos de plástico");
		System.out.println("Esferovite");
	}
	public void imprimirEcopontoAzul() {
		System.out.println("Ecoponto azul (Papel e Cartão:");
		System.out.println("Embalagens de papel");
		System.out.println("Embalagens de cartão");
		System.out.println("Revistas");
		System.out.println("Jornais");
		System.out.println("Papel de escrita e papel de impressão");
	}
	public void imprimirEcopontoVerde() {
		System.out.println("Ecoponto verde (Vidro):");
		System.out.println("Garrafas");
		System.out.println("Frascos");
		System.out.println("Copos de vidro");
	}
	public void imprimirResiduosEspeciais() {
		System.out.println("Reciclagem de resíduos especiais:");
		System.out.println("Medicamentos e radiografias são entregues a farmácias");
		System.out.println("Pilhas e baterias de equipamentos são reciclados no Ecopilhas(pilhão)");
		System.out.println("Lâmpadas são entregues a lojas ou em pontos de eletrão especificos para lâmpadas");
		System.out.println("Equipamentos eletrónicos e elétricos são reciclados na loja de compra ou entidades que gerênciam esses resíduos");
	}
	
}
