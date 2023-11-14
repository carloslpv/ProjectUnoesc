package br.edu.unoesc.desafiofullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unoesc.desafiofullstack.entities.EntityEndereco;

public interface EnderecoRepository extends JpaRepository <EntityEndereco, Long>{
}
