package are.bingo.services.players;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.PlayerResponse;
import are.bingo.services.game.GameService;
import are.bingo.services.utils.UtilsService;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PlayersService implements IPlayersService {

  @Autowired
  PlayerResponse playerResponse;

  @Autowired
  BigDecimal newCredit;

  @Autowired
  GameService gameService;

  @Autowired
  UtilsService utilsService;

  @Override
  public PlayerResponse generateNewPlayer(String playerName) throws Exception {
    log.info("generateNewPlayer start");
    utilsService.fillPlayerData(playerResponse.getPlayer(), playerName);
    playerResponse.getGift().setBalance(newCredit);
    this.gameService.addPlayer(playerResponse.getPlayer());
    log.info("generateNewPlayer end with: " + playerResponse);
    return playerResponse;
  }
}
