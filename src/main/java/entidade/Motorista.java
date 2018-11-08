package entidade;

import java.io.Serializable;

public class Motorista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String nascimento;
	private String cnhNum;
	private String cnhTipo;
	private String endereco;
	private boolean vinculadoCarro;



	public Motorista() {

	}

	public Motorista(String nome, String nascimento, String endereco, String cnhNum, String cnhTipo) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.cnhNum = cnhNum;
		this.cnhTipo = cnhTipo;
		this.vinculadoCarro = false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnhNum == null) ? 0 : cnhNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this.cnhNum != null && obj != null) {
			if(this.cnhNum.equals(obj.toString())) 
				return true;
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCnhNum() {
		return cnhNum;
	}

	public void setCnhNum(String cnhNum) {
		this.cnhNum = cnhNum;
	}

	public String getCnhTipo() {
		return cnhTipo;
	}

	public void setCnhTipo(String cnhTipo) {
		this.cnhTipo = cnhTipo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean getVinculadoCarro() {
		return vinculadoCarro;
	}

	public void setVinculadoCarro(boolean vinculadoCarro) {
		this.vinculadoCarro = vinculadoCarro;
	}

	@Override
	public String toString() {
		return "Motorista [nome=" + nome + ", nascimento=" + nascimento + ", cnhNum=" + cnhNum + ", cnhTipo=" + cnhTipo
				+ ", endereco=" + endereco + ", vinculadoCarro=" + vinculadoCarro + "] \n";
	}

}
