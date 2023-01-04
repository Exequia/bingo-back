package are.bingo.controllers.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import are.bingo.models.GamePlayer;
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
    log.info("add player to the game start");
    List<GamePlayer> gamePlayers = this.gameService.addGamePlayer(gamePlayer);
    log.info("add player to the game end and returns: " + gamePlayers);
    return gamePlayers;
  }
}
