package are.bingo.services.players;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.PlayerResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PlayersService implements IPlayersService {
  @Autowired
  PlayerResponse playerResponse;
  @Autowired
  BigDecimal newCredit;

  @Override
  public PlayerResponse generateNewPlayer(String playerName) {
    log.info("generateNewPlayer start");
    playerResponse.getPlayer().setName(playerName);
    playerResponse.getPlayer().setId(this.generateId());
    playerResponse.getPlayer().setAmount(newCredit);
    playerResponse.getGift().setBalance(newCredit);
    log.info("generateNewPlayer end with: " + playerResponse);
    return playerResponse;
  }

  @Override
  public String generateId() {
    return UUID.randomUUID().toString();
  }

}
