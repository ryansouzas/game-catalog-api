package com.ryansouzas.gamecatalog.controllers;

import com.ryansouzas.gamecatalog.dto.GameMinDTO;
import com.ryansouzas.gamecatalog.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> list = service.findAll();
        return list;
    }
}
