package br.edu.unoesc.desafiofullstack.classes;

import java.sql.Date;

import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;

public record AtualizaPessoa(Long codigo, String nome, String cpf, String sexo, 
		Date dataNascimento) {

	public AtualizaPessoa(EntityPessoa pessoa) {
		this(pessoa.getCodigo(), pessoa.getNome(), pessoa.getCpf(), pessoa.getSexo(), 
				pessoa.getDataNascimento());
	}

	
}
