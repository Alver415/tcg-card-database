package com.garth.tcg.server.service;

import com.garth.tcg.server.model.GameRow;
import com.garth.tcg.server.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService extends EntityService<GameRow> {

    @Autowired
    public GameService(GameRepository gameRepository) {
        super(gameRepository);
    }

}
