package com.diotto.gamelist.controllers;

import com.diotto.gamelist.dto.GameDTO;
import com.diotto.gamelist.dto.GameListDTO;
import com.diotto.gamelist.dto.GameMinDTO;
import com.diotto.gamelist.dto.ReplacementDTO;
import com.diotto.gamelist.entities.GameList;
import com.diotto.gamelist.services.GameListService;
import com.diotto.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;
    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }


}
