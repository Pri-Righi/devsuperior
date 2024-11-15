package com.devsuperiors.dslists.controllers;

import com.devsuperiors.dslists.dto.GameMinDTO;
import com.devsuperiors.dslists.entities.Game;
import com.devsuperiors.dslists.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/games")
public class GameController {
    //porta de entrada do backend; vai disponibiizar a API; recebe o DTO

    @Autowired
    private GameService gameService; //injetando service

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
