package com.ryansouzas.gamecatalog.services;

import com.ryansouzas.gamecatalog.dto.GameDTO;
import com.ryansouzas.gamecatalog.dto.GameMinDTO;
import com.ryansouzas.gamecatalog.entities.Game;
import com.ryansouzas.gamecatalog.repository.GameRepository;
import com.ryansouzas.gamecatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> list = repository.findAll();
        return list.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found"));
        return new GameDTO(entity);
    }
}
