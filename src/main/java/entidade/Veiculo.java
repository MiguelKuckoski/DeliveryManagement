package entidade;

import java.io.Serializable;
import java.util.ArrayList;

public class Veiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String marca;
	private String modelo;
	private String placa;
	private int ano;
	protected ArrayList<Pacote> listaDePacote;
	private Motorista motorista;
	String tipo;

	public Veiculo(String marca, String modelo, String placa, int ano, String tipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.tipo = tipo;

	}

	public Veiculo() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public ArrayList<Pacote> getListaDePacote() {
		return listaDePacote;
	}

	public void setListaDePacote(ArrayList<Pacote> listaDePacote) {
		this.listaDePacote = listaDePacote;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}
