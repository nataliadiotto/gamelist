package com.diotto.gamelist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getReleaseYear();
    String getImgUrl();
    String getShortDescription();
    String getLongDescription();
    Integer getPosition();

}
