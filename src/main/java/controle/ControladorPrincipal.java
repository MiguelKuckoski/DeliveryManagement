package controle;

public class ControladorPrincipal {

	private ControleVeiculo controleVeiculo;
	private ControleMotorista controleMotorista;

	public ControladorPrincipal() {

		this.controleVeiculo = new ControleVeiculo();
		this.controleMotorista = new ControleMotorista();
	}

	public ControleMotorista getControleMotorista() {
		return controleMotorista;
	}

	public void setControleMotorista(ControleMotorista controleMotorista) {
		this.controleMotorista = controleMotorista;
	}

	public ControleVeiculo getControleviculo() {
		return controleVeiculo;
	}

	public void setControleviculo(ControleVeiculo controleviculo) {
		this.controleVeiculo = controleviculo;
	}

}
