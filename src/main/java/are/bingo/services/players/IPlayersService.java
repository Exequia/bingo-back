package are.bingo.services.players;

import are.bingo.models.Player;

public interface IPlayersService {

  public Player generateNewPlayer(String playerName);

  public String generateId();

}
