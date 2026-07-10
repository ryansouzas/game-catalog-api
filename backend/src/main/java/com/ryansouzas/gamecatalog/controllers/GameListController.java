package com.ryansouzas.gamecatalog.controllers;

import com.ryansouzas.gamecatalog.dto.GameListDTO;
import com.ryansouzas.gamecatalog.dto.GameMinDTO;
import com.ryansouzas.gamecatalog.services.GameListService;
import com.ryansouzas.gamecatalog.services.GameService;
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
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> list = service.findAll();
        return list;
    }

    @GetMapping(value = "/{id}/games")
    public List<GameMinDTO> findById(@PathVariable("id") Long id){
        List<GameMinDTO> list = gameService.findByList(id);
        return list;
    }
}
