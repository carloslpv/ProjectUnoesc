package br.edu.unoesc.desafiofullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unoesc.desafiofullstack.entities.EntityPessoa;

public interface PessoaRepository extends JpaRepository <EntityPessoa, Long>{
}
