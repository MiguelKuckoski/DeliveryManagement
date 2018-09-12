package vo;

public class Motorista {
	
	private String nome;
	private String nascimento;
	private String cnhNum;
	private String cnhTipo;
	private Endereco endereco;
	
	public Motorista () {
		super();
	}
	
	public Motorista(String nome, String nascimento, Endereco endereco, String cnhNum, String cnhTipo) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.cnhNum = cnhNum;
		this.cnhTipo = cnhTipo;		
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
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void vincularVeiculo() {
		
	}

}
