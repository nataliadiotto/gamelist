package com.diotto.gamelist.dto;

import com.diotto.gamelist.entities.Game;
import com.diotto.gamelist.projections.GameMinProjection;
import lombok.Getter;

@Getter
public class GameMinDTO {

    private Long id;
    private String title;
    private Integer releaseYear;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {

    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        releaseYear = entity.getReleaseYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        releaseYear = projection.getReleaseYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }
}
