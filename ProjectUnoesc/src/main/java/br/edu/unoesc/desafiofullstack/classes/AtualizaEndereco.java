package br.edu.unoesc.desafiofullstack.classes;

public record AtualizaEndereco(Long codigo, String cep, String logradouro, 
		String numero, String bairro, String localidade, 
		String uf, Pessoa pessoa) {

}
