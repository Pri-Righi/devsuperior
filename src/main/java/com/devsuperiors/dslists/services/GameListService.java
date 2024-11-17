package com.devsuperiors.dslists.services;

import com.devsuperiors.dslists.dto.GameDTO;
import com.devsuperiors.dslists.dto.GameListDTO;
import com.devsuperiors.dslists.dto.GameMinDTO;
import com.devsuperiors.dslists.entities.Game;
import com.devsuperiors.dslists.entities.GameList;
import com.devsuperiors.dslists.projections.GameMinProjection;
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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
