package are.bingo.services.utils;

import java.math.BigDecimal;
import java.util.List;

import are.bingo.models.GamePlayer;
import are.bingo.models.Player;

public interface IUtilsService {
    public void fillPlayerData(Player player, String playerName);

    public String generateId();

    public Player getDummyPlayer(int index);

    public Player getPlayerById(List<Player> players, String playerId);

    public GamePlayer getGamePlayerById(List<GamePlayer> players, String playerId);

    public BigDecimal getShoppingBalance(BigDecimal dashboardPrice, int DashboardAmount);

    public int checkValidOperation(BigDecimal userCredit, BigDecimal shoppingBalance);

    public List<Player> getDummyPlayers(List<Player> players);
}
