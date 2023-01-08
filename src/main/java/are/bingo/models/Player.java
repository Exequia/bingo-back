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
  @Autowired
  private BigDecimal dashboardPrice;
  @Autowired
  private BigDecimal dashboardBonusTwoPrice;
  @Autowired
  private BigDecimal dashboardBonusThreePrice;
}
