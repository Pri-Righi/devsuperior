package com.devsuperiors.dslists.services;

import com.devsuperiors.dslists.dto.GameMinDTO;
import com.devsuperiors.dslists.entities.Game;
import com.devsuperiors.dslists.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    //implementa a logica de negocios; orquestra as operacoes do negocio; devolve um DTO

    @Autowired
    private GameRepository gameRepository; //injetando uma instancia do gamerepository no service
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
