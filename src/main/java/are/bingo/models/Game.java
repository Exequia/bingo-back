package are.bingo.models;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Game {

    @Autowired
    private GameStatus status;
    @Autowired
    private GameConfig config;
}
