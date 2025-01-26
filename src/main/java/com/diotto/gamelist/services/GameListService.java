package com.diotto.gamelist.services;

import com.diotto.gamelist.dto.GameDTO;
import com.diotto.gamelist.dto.GameListDTO;
import com.diotto.gamelist.dto.GameMinDTO;
import com.diotto.gamelist.entities.Game;
import com.diotto.gamelist.entities.GameList;
import com.diotto.gamelist.projections.GameMinProjection;
import com.diotto.gamelist.repositories.GameListRepository;
import com.diotto.gamelist.repositories.GameRepository;
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
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max ; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }


}
