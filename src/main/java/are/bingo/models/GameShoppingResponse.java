package are.bingo.models;

import java.util.List;

import lombok.Data;

@Data
public class GameShoppingResponse {
    Player player;
    List<Dashboard> dashboards;
}
