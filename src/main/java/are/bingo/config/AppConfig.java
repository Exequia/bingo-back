package are.bingo.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import are.bingo.models.Game;
import are.bingo.models.GameConfig;
import are.bingo.models.GamePlayer;
import are.bingo.models.GameStatus;
import are.bingo.models.GiftResponse;
import are.bingo.models.Player;
import are.bingo.models.PlayerResponse;
import are.bingo.models.Round;

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
  public BigDecimal dashboardPrice() {
    return new BigDecimal("5.0");
  }

  @Bean
  public BigDecimal dashboardBonusTwoPrice() {
    return new BigDecimal("1.0");
  }

  @Bean
  public BigDecimal dashboardBonusThreePrice() {
    return new BigDecimal("3.0");
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
  public List<Player> players() {
    return new ArrayList<Player>();
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

  @Bean
  public Random randI() {
    return new Random();
  }

  @Bean
  public GameStatus status() {
    return new GameStatus();
  }

  @Bean
  public Round round() {
    return new Round();
  }
}
