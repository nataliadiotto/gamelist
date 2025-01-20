package com.diotto.gamelist.services;

import com.diotto.gamelist.dto.GameMinDTO;
import com.diotto.gamelist.entities.Game;
import com.diotto.gamelist.repositories.GameRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll() {
        List<Game> games = gameRepository.findAll();
        return games;
    }

}
