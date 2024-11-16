package com.devsuperiors.dslists.repositories;

import com.devsuperiors.dslists.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    //responsavel por acessar, consultar e buscar os dados no banco; devolve uma entidade


}
