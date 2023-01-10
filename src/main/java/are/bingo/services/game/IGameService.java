package are.bingo.services.game;

import java.util.List;

import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GameShoppingRequest;
import are.bingo.models.GameShoppingResponse;
import are.bingo.models.GameStatusEnum;
import are.bingo.models.Player;

public interface IGameService {

    public void addPlayer(Player player);

    public void removePlayer(String playerId);

    public List<GamePlayer> addGamePlayer(GamePlayer gamePlayer);

    public List<GamePlayer> disconectPlayer(String playerId);

    public GameStatusEnum setGameStatus(GameStatusEnum gameStatus) throws Exception;

    public GameConfig setGameConfig(GameConfig gameConfig) throws Exception;

    public void applyPlayersRange(GameConfig gameConfig) throws Exception;

    public void addDummyPlayers(int playersToAdd) throws Exception;

    public GameShoppingResponse gameShopping(GameShoppingRequest shoppingRequest) throws Exception;

    public void shoppingDummyPlayers() throws Exception;
}
