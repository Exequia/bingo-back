package are.bingo.controllers.game;

import java.util.List;

import are.bingo.models.GamePlayer;

public interface IGameController {
    public List<GamePlayer> addPlayers(GamePlayer gamePlayer) throws Exception;
}
