package com.diotto.gamelist.repositories;

import com.diotto.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GameRepository extends JpaRepository<Game, Long> {

}
