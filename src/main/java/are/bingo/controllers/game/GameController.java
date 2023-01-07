package are.bingo.controllers.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import are.bingo.models.GamePlayer;
import are.bingo.models.GameStatusEnum;
import are.bingo.services.game.GameService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class GameController implements IGameController {

@Autowired
private GameService gameService;
    
  @Override
  @MessageMapping("/game/player")
  @SendTo("/topic/game/players")
  public List<GamePlayer> addPlayers(GamePlayer gamePlayer) throws Exception {
    log.info("add player to the game start with values: " + gamePlayer);
    List<GamePlayer> gamePlayers = this.gameService.addGamePlayer(gamePlayer);
    log.info("add player to the game end and returns: " + gamePlayers);
    return gamePlayers;
  }

  @Override
  @MessageMapping("/game/disconect")
  @SendTo("/topic/game/players")
  public List<GamePlayer> disconectPlayer(String playerId) throws Exception {
    log.info("Disconect Player to the game start for Id: " + playerId);
    List<GamePlayer> gamePlayers = this.gameService.disconectPlayer(playerId);
    log.info("Disconect Player to the game end and returns: " + gamePlayers);
    return gamePlayers;
  }

  @Override
  @MessageMapping("/game/status")
  @SendTo("/topic/game/status")
  public GameStatusEnum setGameStatus(GameStatusEnum gameStatus) throws Exception {
    log.info("Set game status start with status: " + gameStatus);
    GameStatusEnum newGameStatus = this.gameService.setGameStatus(gameStatus);
    log.info("Set game status end with status: " + newGameStatus);
    return newGameStatus;
  }
}
