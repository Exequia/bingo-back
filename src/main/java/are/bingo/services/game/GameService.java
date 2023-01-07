package are.bingo.services.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.Game;
import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GameStatusEnum;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Component
@Log4j2
public class GameService implements IGameService {

    @Autowired
    private List<GamePlayer> gamePlayers;

    @Autowired
    private Game game;

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

    @Override
    public GameStatusEnum setGameStatus(GameStatusEnum gameStatus) {
        log.info("Set game status start with status: " + gameStatus);
        this.game.setStatus(gameStatus);
        log.info("Set game status success");
        return this.game.getStatus();
    }

    public GameConfig setGameConfig(GameConfig gameConfig) {
        log.info("Set game config as: " + gameConfig);
        this.game.setConfig(gameConfig);
        log.info("Set game config success");
        return this.game.getConfig();
    }
}
