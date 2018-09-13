package controle;

public class ControladorPrincipal {
	private ControleVeiculo controleviculo;

	public ControladorPrincipal(ControleVeiculo controleviculo) {

		this.controleviculo = controleviculo;
	}

	public ControleVeiculo getControleviculo() {
		return controleviculo;
	}

	public void setControleviculo(ControleVeiculo controleviculo) {
		this.controleviculo = controleviculo;
	}

}
