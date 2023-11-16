package br.edu.unoesc.desafiofullstack.classes;

public record Endereco (String cep, String logradouro, String numero, String bairro, String localidade, 
		String uf, Pessoa pessoa){

}
