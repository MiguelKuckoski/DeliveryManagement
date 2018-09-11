package vo;

public class Pacote {
	
	private String nomeRemetente;
	private String nomeDestino;
	private String codLocalizador;
	private Endereco endRemetente;
	private Endereco endDestino;
	private double peso;
	
	public Pacote () {
		
	}
	
	
	public String getNomeRemetente() {
		return nomeRemetente;
	}
	
	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}
	
	public String getNomeDestino() {
		return nomeDestino;
	}
	
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	public String getCodLocalizador() {
		return codLocalizador;
	}

	public void setCodLocalizador(String codLocalizador) {
		this.codLocalizador = codLocalizador;
	}

	public Endereco getEndRemetente() {
		return endRemetente;
	}

	public void setEndRemetente(Endereco endRemetente) {
		this.endRemetente = endRemetente;
	}

	public Endereco getEndDestino() {
		return endDestino;
	}

	public void setEndDestino(Endereco endDestino) {
		this.endDestino = endDestino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	

}
