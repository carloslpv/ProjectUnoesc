package br.edu.unoesc.desafiofullstack.classes;

//Record seria como se fosse uma classe mas com os dados imutáveis
//Declaração da record Endereco com os dados conforme documentação GIT
public record Endereco (Long codigo, String cep, String logradouro, String numero, String bairro, String municipio, String estado, Pessoa pessoa){
}
