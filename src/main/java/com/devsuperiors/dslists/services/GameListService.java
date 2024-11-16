package com.devsuperiors.dslists.services;

import com.devsuperiors.dslists.dto.GameDTO;
import com.devsuperiors.dslists.dto.GameListDTO;
import com.devsuperiors.dslists.dto.GameMinDTO;
import com.devsuperiors.dslists.entities.Game;
import com.devsuperiors.dslists.entities.GameList;
import com.devsuperiors.dslists.repositories.GameListRepository;
import com.devsuperiors.dslists.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
}
