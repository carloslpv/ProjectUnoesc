package br.edu.unoesc.desafiofullstack.entities;

import java.sql.Date;

//Record seria como se fosse uma classe mas com os dados imutáveis
//Declaração da record Pessoa com os dados conforme documentação GIT
public record Pessoa (Long codigo, String nome, String cpf, String sexo, Date dataNascimento){
}
