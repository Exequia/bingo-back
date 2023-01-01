package are.bingo.controllers.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import are.bingo.models.Player;
import are.bingo.services.players.PlayersService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PlayersController implements IPlayersController {

  @Autowired
  private PlayersService playerService;

  @Override
  @MessageMapping("/players/new")
  @SendTo("/topic/game/players")
  public Player player(@RequestBody Player player) throws Exception {
    log.info("new player controller");
    return this.playerService.generateNewPlayer(player.getName());
  }
}
