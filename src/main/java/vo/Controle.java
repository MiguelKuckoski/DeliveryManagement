package vo;



public class Controle {
	private Veiculo listaVeiculo;
	private Motorista listaMotorista;
	private Pacote listaPacoteComRoteiro;
	private Pacote listaPacoteSemRoteiro;
	private Usuario usuario;
	
	public Controle() {
		
	}
	
	public Veiculo getListaVeiculo() {
		return listaVeiculo;
	}
	public void setListaVeiculo(Veiculo listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}
	public Motorista getListaMotorista() {
		return listaMotorista;
	}
	public void setListaMotorista(Motorista listaMotorista) {
		this.listaMotorista = listaMotorista;
	}
	public Pacote getListapacote() {
		return listaPacoteComRoteiro;
	}
	public void setListapacote(Pacote listapacote) {
		this.listaPacoteComRoteiro = listapacote;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pacote getListaPacoteSemRoteiro() {
		return listaPacoteSemRoteiro;
	}

	public void setListaPacoteSemRoteiro(Pacote listaPacoteSemRoteiro) {
		this.listaPacoteSemRoteiro = listaPacoteSemRoteiro;
	}
}
