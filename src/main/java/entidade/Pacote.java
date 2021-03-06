package entidade;

import java.io.Serializable;
import java.util.Date;

public class Pacote implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3566021722412775799L;
	private String codLocalizador;
	private String nomeRemetente;
	private String nomeDestino;
	private String endRemetente;
	private String endDestino;
	private double peso;
	private boolean entrega;
	private boolean roteirizado;
	private Date dataInsercao;

	public Pacote(String nomeRemetente, String nomeDestino, String codLocalizador, String endRemetente,
			String endDestino, double peso) {
		this.nomeRemetente = nomeRemetente;
		this.nomeDestino = nomeDestino;
		this.codLocalizador = codLocalizador;
		this.endRemetente = endRemetente;
		this.endDestino = endDestino;
		this.peso = peso;
		this.dataInsercao = new Date();
	}

	public Pacote() {

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

	public String getEndRemetente() {
		return endRemetente;
	}

	public void setEndRemetente(String endRemetente) {
		this.endRemetente = endRemetente;
	}

	public String getEndDestino() {
		return endDestino;
	}

	public void setEndDestino(String endDestino) {
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

	public void gerarRastreio(String rastreio) {

	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	@Override
	public String toString() {
		return "Pacote [" + (codLocalizador != null ? "codLocalizador=" + codLocalizador + ", " : "")
				+ (nomeDestino != null ? "nomeDestino=" + nomeDestino + ", " : "")
				+ (endDestino != null ? "endDestino=" + endDestino + ", " : "") + "peso=" + peso + ", "
				+ (dataInsercao != null ? "dataInsercao=" + dataInsercao : "]") + "\n [Roteirizado = " + roteirizado
				+ " Entregue = " + entrega + "] \n";
	}

}
