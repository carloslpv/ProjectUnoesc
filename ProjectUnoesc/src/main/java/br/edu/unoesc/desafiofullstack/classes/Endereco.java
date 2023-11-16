package br.edu.unoesc.desafiofullstack.classes;

import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;

public record Endereco (String cep, String logradouro, String numero, String bairro, String localidade, 
		String uf, Pessoa pessoa){

}
