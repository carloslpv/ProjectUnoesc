package br.edu.unoesc.desafiofullstack.entities;

public class Contato {
	
	//Declaração dos atributos da classe pessoa
	private Long codigo;
	private String telefone;
	private String email;
	//Declaração do atributo pessoa da classe pessoa
	private Pessoa pessoa;
	
	//Construtor declarado como vazio evidenciando que a classe pode ser instanciada sem nenhum argumento
	public Contato() {
	}

	//Getters e Setters para acesso das informações
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
