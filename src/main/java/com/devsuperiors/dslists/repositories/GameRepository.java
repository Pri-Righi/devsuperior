package com.devsuperiors.dslists.repositories;

import com.devsuperiors.dslists.entities.Game;
import com.devsuperiors.dslists.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    //responsavel por acessar, consultar e buscar os dados no banco; devolve uma entidade


    @Query(nativeQuery = true, value = """ 
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")

    //quando utilizamos o nativeQuery, o resultado da consulta precisa ser uma interface "projection"

	List<GameMinProjection> searchByList(Long listId);

    //consulta customizada SQL; metodo com parametros que precisamos para a consulta, no caso quero o ID da lista
}

