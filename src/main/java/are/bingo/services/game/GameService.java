package are.bingo.services.game;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.Game;
import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GameShoppingRequest;
import are.bingo.models.GameShoppingResponse;
import are.bingo.models.GameStatusEnum;
import are.bingo.models.Player;
import are.bingo.services.utils.UtilsService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Component
@Log4j2
public class GameService implements IGameService {

    @Autowired
    private List<Player> players;

    @Autowired
    private List<GamePlayer> gamePlayers;

    @Autowired
    private Game game;

    @Autowired
    private UtilsService utilsService;

    @Override
    public void addPlayer(Player player) {
        log.info("add Player start");
        this.players.add(player);
        log.info("add Player end successful");
    }

    @Override
    public void removePlayer(String playerId) {
        log.info("remove Player start");
        this.players.removeIf(player -> (player.getId().equals(playerId)));
        log.info("remove Player end successful");
    }

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
        this.removePlayer(playerId);
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

    @Override
    public GameConfig setGameConfig(GameConfig gameConfig) {
        log.info("Set game config as: " + gameConfig);
        this.game.setConfig(gameConfig);
        // this.applyPlayersRange(gameConfig);
        log.info("Set game config success");
        return this.game.getConfig();
    }

    @Override
    public void applyPlayersRange(GameConfig gameConfig) {
        int playersToAdd = gameConfig.getMinPlayers() - this.players.size();
        if (playersToAdd > 0) {
            this.addDummyPlayers(playersToAdd);
        }
    }

    @Override
    public void addDummyPlayers(int playersToAdd) {
        // TODO: ARE - Mejorar límites de autocompletar jugadores
        for (int i = 0; i < playersToAdd; i++) {
            Player dummy = this.utilsService.getDummyPlayer(i);
            this.players.add(dummy);
            this.gamePlayers.add(new GamePlayer(dummy));
        }
    }

    @Override
    public GameShoppingResponse gameShopping(GameShoppingRequest shoppingRequest) throws Exception {
        log.info("User shopping : " + shoppingRequest);
        GameShoppingResponse shoppingResponse = new GameShoppingResponse();
        Player user = this.utilsService.getPlaerById(this.players, shoppingRequest.getPlayerId());
        BigDecimal shoppingBalance = this.utilsService.getShoppingBalance(user.getDashboardPrice(),
                shoppingRequest.getDashboardAmount());
        int validOperation = this.utilsService.checkValidOperation(user.getAmount(), shoppingBalance);
        if (validOperation >= 0) {
            shoppingResponse.setDashboards(
                    this.utilsService.getNewDashboards(this.players, shoppingRequest.getDashboardAmount()));
            user.setAmount(user.getAmount().subtract(shoppingBalance));
            shoppingResponse.setPlayer(user);
            log.info("User shopping complete returns: " + shoppingResponse);
            return shoppingResponse;
        } else {
            throw new Exception("invalidUserCredit");
        }
    }
}
