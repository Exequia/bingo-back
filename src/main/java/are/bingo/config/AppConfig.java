package are.bingo.config;

import java.math.BigDecimal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import are.bingo.models.Player;

@Configuration
public class AppConfig {

  @Bean
  public BigDecimal amount() {
    return new BigDecimal("0.0");
  }

  @Bean
  public Player player() {
    return new Player();
  }

}
