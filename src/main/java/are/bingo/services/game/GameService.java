package are.bingo.services.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.GamePlayer;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Component
@Log4j2
public class GameService implements IGameService {

    @Autowired
    private List<GamePlayer> gamePlayers;

    @Override
    public List<GamePlayer> addGamePlayer(GamePlayer gamePlayer) {
        log.info("addGamePlayer start");
        this.gamePlayers.add(gamePlayer);
        log.info("addGamePlayer end with: " + gamePlayers);
        return gamePlayers;
    }

    @Override
    public List<GamePlayer> disconectPlayer(String playerId) {
        log.info("addGamePlayer start");
        this.gamePlayers.removeIf(player -> (player.getId().equals(playerId)));
        log.info("addGamePlayer end with: " + gamePlayers);
        return gamePlayers;
    }
}
