package br.edu.unoesc.desafiofullstack.classes;

import java.sql.Date;

import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;

public record Pessoa (String nome, String cpf, String sexo, Date dataNascimento){
	
	public Pessoa(EntityPessoa pessoa) {
		this(pessoa.getNome(), pessoa.getCpf(), pessoa.getSexo(), pessoa.getDataNascimento());
	}
}
