package com.ryansouzas.gamecatalog.repository;

import com.ryansouzas.gamecatalog.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
