package are.bingo.controllers.game;

import java.util.List;

import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GameShoppingRequest;
import are.bingo.models.GameShoppingResponse;
import are.bingo.models.GameStatus;
import are.bingo.models.GameStatusEnum;

public interface IGameController {
    public List<GamePlayer> addPlayers(GamePlayer gamePlayer) throws Exception;

    public List<GamePlayer> disconectPlayer(String playerId) throws Exception;

    public GameStatus setGameStatus(GameStatusEnum gameStatus) throws Exception;

    public GameConfig setGameConfig(GameConfig gameConfig) throws Exception;
    
    public GameShoppingResponse gameShopping(GameShoppingRequest shoppingRequest) throws Exception;
}
