package are.bingo.models;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class GiftResponse {
    private GiftResponseEnum type = GiftResponseEnum.CREDIT;
    @Autowired
    private BigDecimal balance;
    private BalanceTypeEnum balanceType = BalanceTypeEnum.ADD;
}
