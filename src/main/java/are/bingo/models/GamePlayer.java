package are.bingo.models;

import lombok.Data;

@Data
public class GamePlayer {
    
    public GamePlayer() {
    }

    public GamePlayer(Player player) {
        this.id = player.getId();
        this.name = player.getName();
    }

    private String id;
    private String name;
}
