package com.devsuperiors.dslists.repositories;

import com.devsuperiors.dslists.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    //responsavel por acessar, consultar e buscar os dados no banco; devolve uma entidade


}
