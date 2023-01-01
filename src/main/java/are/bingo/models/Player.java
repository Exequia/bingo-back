package are.bingo.models;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Player {

  private String id;
  private String name;
  @Autowired
  private BigDecimal amount;
  // @Value("${propertyTwo}")
  // private String propertyTwo;

}
