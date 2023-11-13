package br.edu.unoesc.desafiofullstack.entities;

//Record seria como se fosse uma classe mas com os dados imutáveis
//Declaração da record Contato com os dados conforme documentação GIT
public record Contato (Long codigo, String telefone, String email, Pessoa pessoa){
}
