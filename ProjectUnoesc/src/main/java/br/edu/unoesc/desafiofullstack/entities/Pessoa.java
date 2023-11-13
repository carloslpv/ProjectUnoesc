package br.edu.unoesc.desafiofullstack.entities;

import java.sql.Date;

public class Pessoa {
	
	//Declaração dos atributos da classe pessoa
	private Long codigo;
	private String nome;
	private String cpf;
	private String sexo;
	private Date dataNascimento;
	
	//Construtor declarado como vazio evidenciando que a classe pode ser instanciada sem nenhum argumento
	public Pessoa() {
	}

	//Getters e Setters para acesso das informações
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
}
