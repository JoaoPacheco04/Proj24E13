package Projeto;

public class Mensagem {
    private String nomeCliente;
    private String ccCliente;
    private String mailCliente;
    private String mensagemCliente;
    private String resposta;

    public Mensagem(String mailCliente,String nomeCliente, String ccCliente, String mensagemCliente) {
    	this.mailCliente = mailCliente;
    	this.nomeCliente = nomeCliente;
        this.ccCliente = ccCliente;
        this.mensagemCliente = mensagemCliente;
        this.resposta = null;
    }

    public String getNomeCliente() { 
    	return nomeCliente; }
    
    public String getCCCliente() { 
    	return ccCliente; }
    
    public String getMailCliente() {
    	return mailCliente;
    }
    
    public String getMensagemCliente() { 
    	return mensagemCliente;
    }
    
    public String getResposta() { 
    	return resposta; 
    }
    
    public void setResposta(String resposta) { 
    	this.resposta = resposta;
    }
    
}
