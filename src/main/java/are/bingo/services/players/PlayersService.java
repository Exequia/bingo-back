package are.bingo.services.players;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.Player;

@Component
public class PlayersService implements IPlayersService {
  @Autowired
  Player player;

  @Override
  public Player generateNewPlayer(String playerName) {
    player.setName(playerName);
    player.setId(this.generateId());
    return player;
  }

  @Override
  public String generateId() {
    return UUID.randomUUID().toString();
  }

}
