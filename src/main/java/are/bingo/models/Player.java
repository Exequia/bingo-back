package are.bingo.models;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Player {

  private String id;
  private String name;
  @Autowired
  private BigDecimal amount;

}
