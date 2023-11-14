package br.edu.unoesc.desafiofullstack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.unoesc.desafiofullstack.entities.EntityContato;

public interface ContatoRepository extends JpaRepository <EntityContato, Long>{
}
