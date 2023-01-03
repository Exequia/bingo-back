package are.bingo.models;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class PlayerResponse {
    @Autowired
    private Player player;
    @Autowired
    private GiftResponse gift;
}
