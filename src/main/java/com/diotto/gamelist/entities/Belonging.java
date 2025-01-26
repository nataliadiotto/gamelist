package com.diotto.gamelist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_belonging")
@Getter
@Setter
@NoArgsConstructor
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging(Game game, GameList gameList, Integer position) {
        id.setGame(game);
        id.setGameList(gameList);
        this.position = position;
    }
}
