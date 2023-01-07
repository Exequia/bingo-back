package are.bingo.models;

import lombok.Data;

@Data
public class GameConfig {

    private GameVelocityEnum velocity;
    private int rounds;
    private int minPlayers;
    private int maxPlayers;
}
