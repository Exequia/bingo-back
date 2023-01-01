package are.bingo.controllers.players;

import org.springframework.web.bind.annotation.RequestBody;

import are.bingo.models.Player;

public interface IPlayersController {
  public Player player(@RequestBody Player player) throws Exception;
}
