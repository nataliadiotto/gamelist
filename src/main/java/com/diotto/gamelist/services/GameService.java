package com.diotto.gamelist.services;

import com.diotto.gamelist.dto.GameDTO;
import com.diotto.gamelist.dto.GameMinDTO;
import com.diotto.gamelist.entities.Game;
import com.diotto.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> games = gameRepository.findAll();
        List<GameMinDTO> dto = games.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

}
