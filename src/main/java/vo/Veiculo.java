package vo;

public class Veiculo {
	
	private String marca;
	private String modelo;
	private String placa;
	private int ano;
	private Pacote listaDePacote;
	private Motorista motorista;
	
	public Veiculo(String marca,String modelo, String placa,int ano,Pacote listaDePacote,Motorista motorista) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.listaDePacote = listaDePacote;
		this.motorista = motorista;
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

	public Pacote getListaDePacote() {
		return listaDePacote;
	}

	public void setListaDePacote(Pacote listaDePacote) {
		this.listaDePacote = listaDePacote;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}
