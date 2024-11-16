package com.devsuperiors.dslists.services;

import com.devsuperiors.dslists.dto.GameDTO;
import com.devsuperiors.dslists.dto.GameMinDTO;
import com.devsuperiors.dslists.entities.Game;
import com.devsuperiors.dslists.projections.GameMinProjection;
import com.devsuperiors.dslists.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {
    //implementa a logica de negocios; orquestra as operacoes do negocio; devolve um DTO

    @Autowired
    private GameRepository gameRepository; //injetando uma instancia do gamerepository no service

    @Transactional(readOnly = true)
    public GameDTO findById(Long listId) {
        Game result = gameRepository.findById(listId).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }


}
