package are.bingo.services.game;

import java.util.List;

import are.bingo.models.GamePlayer;

public interface IGameService {
    public List<GamePlayer> addGamePlayer(GamePlayer gamePlayer);
}