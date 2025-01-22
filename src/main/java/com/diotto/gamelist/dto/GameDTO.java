package com.diotto.gamelist.dto;

import com.diotto.gamelist.entities.Game;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String title;
    private Double score;
    private Integer releaseYear;
    private String genre;
    private String platform;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game entity) {
//       id = entity.getId();
//       title = entity.getTitle();
//       score = entity.getScore();
//       releaseYear = entity.getReleaseYear();
//       genre = entity.getGenre();
//       platform = entity.getPlatform();
//       imgUrl = entity.getImgUrl();
//       shortDescription = entity.getShortDescription();
//       longDescription = entity.getLongDescription();
        BeanUtils.copyProperties(entity, this);
    }
}
