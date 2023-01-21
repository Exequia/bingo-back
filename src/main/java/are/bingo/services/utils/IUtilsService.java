package are.bingo.services.utils;

import java.math.BigDecimal;
import java.util.List;

import are.bingo.models.Dashboard;
import are.bingo.models.DashboardsLines;
import are.bingo.models.GamePlayer;
import are.bingo.models.Player;
import are.bingo.models.Round;

public interface IUtilsService {
    public void fillPlayerData(Player player, String playerName);

    public String generateId();

    public Player getDummyPlayer(int index);

    public Player getPlayerById(List<Player> players, String playerId);

    public GamePlayer getGamePlayerById(List<GamePlayer> players, String playerId);

    public BigDecimal getShoppingBalance(BigDecimal dashboardPrice, int DashboardAmount);

    public int checkValidOperation(BigDecimal userCredit, BigDecimal shoppingBalance);

    public int getRandomInt(int bound);

    public int getRandomDashboardValue();

    public List<Dashboard> getNewDashboards(List<Player> players, int dashboardAmount);

    public boolean checkValidDashboard(List<Player> players, Dashboard dashboard);

    public Dashboard getRandomDashboard();

    public List<DashboardsLines> getDashboardLines();

    public void getNewDashboardLine(List<DashboardsLines> dashboardsLines);

    public List<Integer> getLineBaseValues();

    public void getDashboardLinesValues(List<DashboardsLines> dashboardsLines, List<Integer> colValues);

    public boolean checkValidValue(List<DashboardsLines> dashboardsLines, List<Integer> lineValues, Integer value);

    public void addValue(List<DashboardsLines> dashboardsLines, List<Integer> lineValues, Integer value);

    public List<Player> getDummyPlayers(List<Player> players);

    public void getRoundNewValue(Round round);

    public boolean checkValidValue(Integer newValue, List<Integer> values);
}
