package are.bingo.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import are.bingo.models.Game;
import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GiftResponse;
import are.bingo.models.Player;
import are.bingo.models.PlayerResponse;

@Configuration
public class AppConfig {

  @Bean
  public BigDecimal amount() {
    return new BigDecimal("0.0");
  }

  @Bean
  public BigDecimal balance() {
    return new BigDecimal("0.0");
  }

  @Bean
  public BigDecimal newCredit() {
    return new BigDecimal("100.0");
  }

  @Bean
  public Player player() {
    return new Player();
  }

  @Bean
  public GiftResponse giftResponse() {
    return new GiftResponse();
  }

  @Bean
  public PlayerResponse playerResponse() {
    return new PlayerResponse();
  }

  @Bean
  public List<GamePlayer> gamePlayers() {
    return new ArrayList<GamePlayer>();
  }

  @Bean
  public Game game() {
    return new Game();
  }

  @Bean
  public GameConfig config() {
    return new GameConfig();
  }

}
