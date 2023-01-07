package are.bingo.controllers.game;

import java.util.List;

import are.bingo.models.GamePlayer;
import are.bingo.models.GameStatusEnum;

public interface IGameController {
    public List<GamePlayer> addPlayers(GamePlayer gamePlayer) throws Exception;

    public List<GamePlayer> disconectPlayer(String playerId) throws Exception;

    public GameStatusEnum setGameStatus(GameStatusEnum gameStatus) throws Exception;
}
