package are.bingo.services.game;

import java.util.List;

import are.bingo.models.GamePlayer;
import are.bingo.models.GameStatusEnum;

public interface IGameService {
    public List<GamePlayer> addGamePlayer(GamePlayer gamePlayer);

    public List<GamePlayer> disconectPlayer(String playerId);

    public GameStatusEnum setGameStatus(GameStatusEnum gameStatus);
}
