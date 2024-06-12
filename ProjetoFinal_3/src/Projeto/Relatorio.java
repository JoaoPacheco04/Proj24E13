package Projeto;

public class Relatorio {
    private String tipoResiduo;
    private double quant;

    public Relatorio(String tipoResiduo, double quant) {
        this.tipoResiduo = tipoResiduo;
        this.quant = quant;
    }

    public String getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(String tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

	@Override
	public String toString() {
		return "Relatório: Tipo de resíduo:" + tipoResiduo + ", Quantidade=" + quant + "kg";
	}
}

