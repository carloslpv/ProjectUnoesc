package br.edu.unoesc.desafiofullstack.entities;

import br.edu.unoesc.desafiofullstack.classes.AtualizaContato;
import br.edu.unoesc.desafiofullstack.classes.AtualizaPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class EntityContato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String telefone;
	private String email;
	
	@OneToOne
	@JoinColumn(name = "tb_pessoa_codigo")
	private EntityPessoa pessoa;
	
	public EntityContato() {
	}
	
	public void atualizaContato(AtualizaContato consultaJson) {
		if(consultaJson.codigo() != null) {
			this.codigo = consultaJson.codigo();
		}
		if(consultaJson.telefone() != null) {
			this.telefone = consultaJson.telefone();
		}
		if(consultaJson.email() != null) {
			this.email = consultaJson.email();
		}
	}

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

	public EntityPessoa getPessoa() {
		return pessoa;
	}

	public EntityContato setPessoa(EntityPessoa pessoa) {
		this.pessoa = pessoa;
		return this;
	}
	
}
