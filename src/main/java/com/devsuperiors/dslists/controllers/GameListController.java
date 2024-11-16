package com.devsuperiors.dslists.controllers;

import com.devsuperiors.dslists.dto.GameDTO;
import com.devsuperiors.dslists.dto.GameListDTO;
import com.devsuperiors.dslists.dto.GameMinDTO;
import com.devsuperiors.dslists.services.GameListService;
import com.devsuperiors.dslists.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

}
