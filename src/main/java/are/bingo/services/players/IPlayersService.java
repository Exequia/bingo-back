package are.bingo.services.players;

import are.bingo.models.PlayerResponse;

public interface IPlayersService {

  public PlayerResponse generateNewPlayer(String playerName) throws Exception;
}
