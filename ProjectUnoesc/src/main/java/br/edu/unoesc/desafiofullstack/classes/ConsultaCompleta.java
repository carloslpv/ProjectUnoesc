package br.edu.unoesc.desafiofullstack.classes;

import br.edu.unoesc.desafiofullstack.entities.EntityContato;
import br.edu.unoesc.desafiofullstack.entities.EntityEndereco;
import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;

public record ConsultaCompleta(EntityPessoa pessoa, EntityEndereco endereco, EntityContato contato) {
}
