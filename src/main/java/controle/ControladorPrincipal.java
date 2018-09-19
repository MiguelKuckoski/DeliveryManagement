package controle;

public class ControladorPrincipal {

	private ControleVeiculo controleVeiculo;
	private ControleMotorista controleMotorista;
	private ControlePacote controlePacote;

	public ControladorPrincipal() {

		this.controleVeiculo = new ControleVeiculo();
		this.controleMotorista = new ControleMotorista();
		this.controlePacote = new ControlePacote();
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

	public ControleVeiculo getControleVeiculo() {
		return controleVeiculo;
	}

	public void setControleVeiculo(ControleVeiculo controleVeiculo) {
		this.controleVeiculo = controleVeiculo;
	}

	public ControlePacote getControlePacote() {
		return controlePacote;
	}

	public void setControlePacote(ControlePacote controlePacote) {
		this.controlePacote = controlePacote;
	}

}
