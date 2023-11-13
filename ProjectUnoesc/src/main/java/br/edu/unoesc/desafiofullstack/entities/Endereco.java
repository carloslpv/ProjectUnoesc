package br.edu.unoesc.desafiofullstack.entities;

public class Endereco {
	
	//Declaração dos atributos da classe pessoa
	private Long codigo;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String municipio;
	private String estado;
	//Declaração do atributo pessoa da classe pessoa
	private Pessoa pessoa;
	
	//Construtor declarado como vazio evidenciando que a classe pode ser instanciada sem nenhum argumento
	public Endereco() {
	}
	
	//Getters e Setters para acesso das informações
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
