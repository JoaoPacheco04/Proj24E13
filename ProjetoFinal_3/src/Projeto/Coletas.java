package Projeto;

public class Coletas {
	private String data;
	private String hora;
	private String localidade;
	
	public Coletas(String data, String hora, String localidade) {
		this.data = data;
		this.hora = hora;
		this.localidade = localidade;
	}
	public String getData() {
		return data;
	}
	public String getHora() {
		return hora;
	}
	public String getLocalidade() {
		return localidade;
	}
	@Override
	public String toString() {
		return "Coletas: Data:" + data + ", Hora:" + hora + ", Localização:" + localidade;
	}
	
}
