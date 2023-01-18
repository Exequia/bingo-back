package are.bingo.controllers.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GameShoppingRequest;
import are.bingo.models.GameShoppingResponse;
import are.bingo.models.GameStatus;
import are.bingo.models.GameStatusEnum;
import are.bingo.services.game.GameService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class GameController implements IGameController {

  @Autowired
  private GameService gameService;
  @Autowired
  private SimpMessagingTemplate template;

  @Override
  @MessageMapping("/game/player")
  @SendTo("/topic/game/players")
  public List<GamePlayer> addPlayers(GamePlayer gamePlayer) throws Exception {
    log.info("add player to the game start with values: " + gamePlayer);
    List<GamePlayer> gamePlayers = this.gameService.addGamePlayer(gamePlayer);
    this.gameService.emitGamePlayers(this.template);
    log.info("add player to the game end and returns: " + gamePlayers);
    return gamePlayers;
  }

  @Override
  @MessageMapping("/game/disconect")
  @SendTo("/topic/game/players")
  public List<GamePlayer> disconectPlayer(String playerId) throws Exception {
    log.info("Disconect Player to the game start for Id: " + playerId);
    List<GamePlayer> gamePlayers = this.gameService.disconectPlayer(playerId);
    this.gameService.emitGamePlayers(this.template);
    log.info("Disconect Player to the game end and returns: " + gamePlayers);
    return gamePlayers;
  }

  @Override
  @MessageMapping("/game/status")
  @SendTo("/topic/game/status")
  public GameStatus setGameStatus(GameStatusEnum gameStatus) throws Exception {
    log.info("Set game status start with status: " + gameStatus);
    GameStatus newGameStatus = this.gameService.setGameStatus(gameStatus);
    log.info("Set game status end with status: " + newGameStatus);
    return newGameStatus;
  }

  @Override
  @MessageMapping("/game/config")
  @SendTo("/topic/game/config")
  public GameConfig setGameConfig(GameConfig gameConfig) throws Exception {
    log.info("Set game config as: " + gameConfig);
    GameConfig newgameConfig = this.gameService.setGameConfig(gameConfig);
    this.gameService.emitGamePlayers(this.template);
    this.gameService.emitGameStatus(this.template);
    log.info("Set game config returns: " + newgameConfig);
    return newgameConfig;
  }

  @Override
  @MessageMapping("/game/shopping")
  @SendToUser("/queue/roundDashboards")
  public GameShoppingResponse gameShopping(GameShoppingRequest shoppingRequest) throws Exception {
    log.info("User shopping : " + shoppingRequest);
    GameShoppingResponse newgameConfig = this.gameService.gameShopping(shoppingRequest);
    this.gameService.emitGamePlayers(this.template);
    this.gameService.checkAllGamePlayersReady(this.template);
    log.info("User shopping complete returns: " + newgameConfig);
    return newgameConfig;
  }
}
