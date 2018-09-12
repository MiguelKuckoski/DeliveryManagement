package vo;

import java.util.HashMap;
import java.util.HashSet;

public class Controle {
	private HashSet<Veiculo> listaVeiculo = new HashSet<Veiculo>();
	private HashSet<Motorista> listaMotorista = new HashSet<Motorista>();
	private HashMap<String, Pacote> listaPacoteComRoteiro = new HashMap<String, Pacote>();
	private HashMap<String, Pacote> listaPacoteSemRoteiro = new HashMap<String, Pacote>();

	public Controle() {

	}

	public HashSet<Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(HashSet<Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	public HashSet<Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(HashSet<Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}

	public HashMap<String, Pacote> getListapacote() {
		return listaPacoteComRoteiro;
	}

	public void setListapacote(HashMap<String, Pacote> listapacote) {
		this.listaPacoteComRoteiro = listapacote;
	}

	public HashMap<String, Pacote> getListaPacoteSemRoteiro() {
		return listaPacoteSemRoteiro;
	}

	public void setListaPacoteSemRoteiro(HashMap<String, Pacote> listaPacoteSemRoteiro) {
		this.listaPacoteSemRoteiro = listaPacoteSemRoteiro;
	}
}
