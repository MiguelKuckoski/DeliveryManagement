package vo;

public class Pacote {
	
	private String nomeRemetente;
	private String nomeDestino;
	private String codLocalizador;
	private Endereco endRemetente;
	private Endereco endDestino;
	private double peso;
	private boolean entrega;
	private boolean roteirizado;
	private int idInsercao;
	
	public Pacote (String nomeRemetente, String nomeDestino,String codLocalizador,Endereco endRemetente,Endereco endDestino,
			double peso, int idInsercao) {
		this.nomeRemetente = nomeRemetente;
		this.nomeDestino = nomeDestino;
		this.codLocalizador = codLocalizador;
		this.endRemetente = endRemetente;
		this.endDestino = endDestino;
		this.peso = peso;
		this.idInsercao = idInsercao;
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


	public boolean isEntrega() {
		return entrega;
	}


	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}


	public boolean isRoteirizado() {
		return roteirizado;
	}


	public void setRoteirizado(boolean roteirizado) {
		this.roteirizado = roteirizado;
	}


	public int getIdInsercao() {
		return idInsercao;
	}


	public void setIdInsercao(int idInsercao) {
		this.idInsercao = idInsercao;
	}
	
	
	public void gerarRastreio(String rastreio) {
		
	}
}
