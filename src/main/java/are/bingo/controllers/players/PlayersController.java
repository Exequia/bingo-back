package are.bingo.controllers.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import are.bingo.models.Player;
import are.bingo.models.PlayerResponse;
import are.bingo.services.players.PlayersService;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PlayersController implements IPlayersController {

  @Autowired
  private PlayersService playerService;

  @Override
  @MessageMapping("/players/new")
  @SendToUser("/queue/reply")
  public PlayerResponse newPlayer(@RequestBody Player player) throws Exception {
    log.info("new player controller start");
    PlayerResponse pResponse = this.playerService.generateNewPlayer(player.getName());
    log.info("new player controller end with: " + pResponse);
    return pResponse;
  }

  @MessageExceptionHandler
  @SendTo("/queue/errors")
  public String handleException(Throwable exception) {
    return exception.getMessage();
  }
}
