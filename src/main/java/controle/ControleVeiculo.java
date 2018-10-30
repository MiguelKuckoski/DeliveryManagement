package controle;

import entidade.Veiculo;
import persistencia.file.MotoristaFileDAO;
import persistencia.file.VeiculoFileDAO;

public class ControleVeiculo {

	private VeiculoFileDAO veiculoDAO = new VeiculoFileDAO();
	private MotoristaFileDAO motoristaDAO = new MotoristaFileDAO();

	public VeiculoFileDAO getVeiculoDAO() {
		return veiculoDAO;
	}

	public void setVeiculoDAO(VeiculoFileDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	public ControleVeiculo() {
		this.veiculoDAO = new VeiculoFileDAO();
	}

	public void cadastrarVeiculo(String marca, String modelo, String placa, int ano, String tipo) {
		Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, tipo);
		veiculoDAO.put(placa,veiculo);
	}
	
	public String desvincularMotorista(String placaVeiculo) {
		
		if(veiculoDAO.getListaVeiculo().containsKey(placaVeiculo) ) {
			if(veiculoDAO.getListaVeiculo().get(placaVeiculo).getMotorista() != null) {			
				
				String cnhMotorista = veiculoDAO.getListaVeiculo().get(placaVeiculo).getMotorista().getCnhNum();
				
				if(veiculoDAO.getListaVeiculo().get(placaVeiculo).desvincularMotorista(veiculoDAO.getListaVeiculo().get(placaVeiculo).getMotorista())) {
					motoristaDAO.getListaMotorista().get(cnhMotorista).setVinculadoCarro(false);
					veiculoDAO.persist();
					motoristaDAO.persit();
					return "Removido com sucesso";
				}else {
					return "Erro ao removir";
				}				
			}else {
				return "Veiculo sem motorista ja vinculado";
			}
		}else {
			return "Placa ou Cnh não existe OU Sem motorista vinculado";
		}				
	}
		
	public String vincularMotorista(String placaVeiculo, String cnhMotorista) {
				
		if(veiculoDAO.getListaVeiculo().containsKey(placaVeiculo) && motoristaDAO.getListaMotorista().containsKey(cnhMotorista) && !motoristaDAO.getListaMotorista().get(cnhMotorista).getVinculadoCarro()) {
			if(veiculoDAO.getListaVeiculo().get(placaVeiculo).getMotorista() == null) {
				
				if(veiculoDAO.getListaVeiculo().get(placaVeiculo).vincularMotorista(motoristaDAO.getListaMotorista().get(cnhMotorista))) {
					motoristaDAO.getListaMotorista().get(cnhMotorista).setVinculadoCarro(true);
					veiculoDAO.persist();
					motoristaDAO.persit();
					return "Vinculado com sucesso";
				}else {
					return "Motorista com CNH não permitida para o veículo";
				}
				
			}else {
				return "Veiculo com motorista ja vinculado";
			}
		}else {
			return "Placa ou Cnh não existe OU Motorista ja vinculado";
		}				
	}

}
