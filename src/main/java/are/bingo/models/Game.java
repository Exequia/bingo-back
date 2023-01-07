package are.bingo.models;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Game {

    private GameStatusEnum status = GameStatusEnum.PENDING;
    @Autowired
    private GameConfig config;
}
