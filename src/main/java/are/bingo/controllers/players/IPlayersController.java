package are.bingo.controllers.players;

import org.springframework.web.bind.annotation.RequestBody;

import are.bingo.models.Player;
import are.bingo.models.PlayerResponse;

public interface IPlayersController {
  public PlayerResponse newPlayer(@RequestBody Player player) throws Exception;
}
