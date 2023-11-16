package br.edu.unoesc.desafiofullstack.classes;

import java.sql.Date;

import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;

//Record seria como se fosse uma classe mas com os dados imutáveis
//Declaração da record Pessoa com os dados conforme documentação GIT
public record Pessoa (String nome, String cpf, String sexo, Date dataNascimento){
	
	public Pessoa(EntityPessoa pessoa) {
		this(pessoa.getNome(), pessoa.getCpf(), pessoa.getSexo(), pessoa.getDataNascimento());
	}
}
