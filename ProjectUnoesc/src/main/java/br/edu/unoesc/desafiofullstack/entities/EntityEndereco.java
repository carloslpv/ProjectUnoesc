package br.edu.unoesc.desafiofullstack.entities;

import br.edu.unoesc.desafiofullstack.classes.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class EntityEndereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String municipio;
	private String estado;
	
	@OneToOne
	@JoinColumn(name = "tb_pessoa_codigo")
	private EntityPessoa pessoa;
	
	public EntityEndereco() {		
	}
	
	public EntityEndereco(Endereco enderecoJson) {
		
		this.cep = enderecoJson.cep();
		this.bairro = enderecoJson.bairro();
		this.estado = enderecoJson.uf();
		this.logradouro = enderecoJson.logradouro();
		this.municipio = enderecoJson.localidade();
		this.numero = enderecoJson.numero();

	}
	

	public void atualizaEndereco(Endereco enderecoJson) {
		if(enderecoJson.cep() != null) {
			this.cep = enderecoJson.cep();
		}
		if(enderecoJson.bairro() != null) {
			this.bairro = enderecoJson.bairro();
		}
		if(enderecoJson.uf() != null) {
			this.estado = enderecoJson.uf();
		}
		if(enderecoJson.logradouro() != null) {
			this.logradouro = enderecoJson.logradouro();
		}
		if(enderecoJson.localidade() != null) {
			this.municipio = enderecoJson.localidade();
		}
		if(enderecoJson.numero() != null) {
			this.numero = enderecoJson.numero();
		}
		
	}

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

	public EntityPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EntityPessoa pessoa) {
		this.pessoa = pessoa;
	}

	
}
