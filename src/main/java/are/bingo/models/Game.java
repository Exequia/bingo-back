package are.bingo.models;

import lombok.Data;

@Data
public class Game {

    private GameStatusEnum status = GameStatusEnum.PENDING;

}
