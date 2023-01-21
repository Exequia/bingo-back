package are.bingo.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Game {

    @Autowired
    private GameStatus status;
    @Autowired
    private GameConfig config;
    @Autowired
    private Round round;
    @Autowired
    private List<Round> history = new ArrayList<Round>();
}
