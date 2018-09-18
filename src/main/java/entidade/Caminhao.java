package entidade;

import java.io.Serializable;

public class Caminhao extends Veiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Caminhao() {
		this.listaDePacote = new Pacote[3];
	}

	public Caminhao(String marca, String modelo, String placa, int ano, Pacote[] listaDePacote) {
		super(marca, modelo, placa, ano, listaDePacote);
		this.listaDePacote = new Pacote[10];

	}
}
