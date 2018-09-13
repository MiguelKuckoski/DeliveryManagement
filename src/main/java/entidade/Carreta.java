package entidade;

import java.io.Serializable;

public class Carreta extends Veiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Carreta() {
		this.listaDePacote = new Pacote[10];
	}

	public Carreta(String marca, String modelo, String placa, int ano, Pacote[] listaDePacote, Motorista motorista) {
		super(marca, modelo, placa, ano, listaDePacote, motorista);
		this.listaDePacote = new Pacote[10];
	}

}
