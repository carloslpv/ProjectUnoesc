package br.edu.unoesc.desafiofullstack.entities;

import java.sql.Date;

import br.edu.unoesc.desafiofullstack.classes.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class EntityPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private String cpf;
	private String sexo;
	private Date dataNascimento;
	
	//Construtor que irá receber os parametros de pessoa do controller
	public EntityPessoa(Pessoa dados) {
		this.codigo = dados.codigo();
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.sexo = dados.sexo();
		this.dataNascimento = dados.dataNascimento();
	}

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
