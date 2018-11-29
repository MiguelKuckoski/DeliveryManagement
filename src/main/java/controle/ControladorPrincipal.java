package controle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ControladorPrincipal {

	private final Properties properties;

	private static ControleVeiculo controleVeiculo;
	private static ControleMotorista controleMotorista;
	private static ControlePacote controlePacote;
	private static ControleRota controleRota;

	private static ControladorPrincipal instancia = new ControladorPrincipal();

	private ControladorPrincipal() {

		this.properties = new Properties();
		FileInputStream resource;
		try {
			resource = new FileInputStream("./arquivos/config.properties");
			properties.load(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String persistencia = this.properties.getProperty("config");
		start(persistencia);
	}

	public static ControladorPrincipal getInstancia() {
		return instancia;
	}

	private void start(String persistencia) {
		controleVeiculo = new ControleVeiculo(persistencia);
		controleMotorista = new ControleMotorista(persistencia);
		controlePacote = new ControlePacote(persistencia);
		// this.controleRota = new ControleRota(this, persistencia);
	}

	public ControleMotorista getControleMotorista() {
		return controleMotorista;
	}

	public void setControleMotorista(ControleMotorista controleMotorista) {
		ControladorPrincipal.controleMotorista = controleMotorista;
	}

	public ControleVeiculo getControleviculo() {
		return controleVeiculo;
	}

	public void setControleviculo(ControleVeiculo controleviculo) {
		controleVeiculo = controleviculo;
	}

	public ControleVeiculo getControleVeiculo() {
		return controleVeiculo;
	}

	public void setControleVeiculo(ControleVeiculo controleVeiculo) {
		ControladorPrincipal.controleVeiculo = controleVeiculo;
	}

	public ControlePacote getControlePacote() {
		return controlePacote;
	}

	public void setControlePacote(ControlePacote controlePacote) {
		ControladorPrincipal.controlePacote = controlePacote;
	}

	public ControleRota getControleRota() {
		return controleRota;
	}

	public void setControleRota(ControleRota controleRota) {
		ControladorPrincipal.controleRota = controleRota;
	}

}
