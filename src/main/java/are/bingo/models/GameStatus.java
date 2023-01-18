package are.bingo.models;

import lombok.Data;

@Data
public class GameStatus {
    private GameStatusEnum status = GameStatusEnum.PENDING;
    private Integer currentRound = 1;
}
