package are.bingo.services.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import are.bingo.models.Dashboard;
import are.bingo.models.DashboardsLines;
import are.bingo.models.GamePlayer;
import are.bingo.models.Player;
import are.bingo.models.Round;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class UtilsService implements IUtilsService {

    @Autowired
    BigDecimal newCredit;
    @Autowired
    private BigDecimal dashboardPrice;
    @Autowired
    private BigDecimal dashboardBonusTwoPrice;
    @Autowired
    private BigDecimal dashboardBonusThreePrice;

    @Autowired
    Random randI;

    @Override
    public void fillPlayerData(Player player, String playerName) {
        player.setName(playerName);
        player.setId(this.generateId());
        player.setAmount(newCredit);
        player.setDashboardPrice(dashboardPrice);
        player.setDashboardBonusTwoPrice(dashboardBonusTwoPrice);
        player.setDashboardBonusThreePrice(dashboardBonusThreePrice);
    }

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Player getDummyPlayer(int index) {
        String[] dummyPlayersNames = new String[] { "Goku", "Bulma", "Vegeta", "Clara", "Iruma", "Azazel", "Samael",
                "Gabriel", "Uriel", "Jon", "Antonia", "White", "Aria", "Hodor", "Sansa" };
        Player dummy = new Player();
        dummy.setDummy(true);
        this.fillPlayerData(dummy, dummyPlayersNames[index]);
        return dummy;
    }

    @Override
    public Player getPlayerById(List<Player> players, String playerId) {
        return players.stream()
                .filter(player -> playerId.equals(player.getId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public GamePlayer getGamePlayerById(List<GamePlayer> players, String playerId) {
        return players.stream()
                .filter(player -> playerId.equals(player.getId()))
                .findAny()
                .orElse(null);
    }

    @Override
    public BigDecimal getShoppingBalance(BigDecimal dashboardPrice, int DashboardAmount) {
        return dashboardPrice.multiply(new BigDecimal(DashboardAmount));
    }

    @Override
    public int checkValidOperation(BigDecimal userCredit, BigDecimal shoppingBalance) {
        return userCredit.compareTo(shoppingBalance);
    }

    @Override
    public int getRandomInt(int bound) {
        return randI.nextInt(bound);
    }

    @Override
    public int getRandomDashboardValue() {
        int myRandInt = randI.nextInt(90);
        return myRandInt + 1;
    }

    @Override
    public List<Dashboard> getNewDashboards(List<Player> players, int dashboardAmount) {
        log.info("getNewDashboards starts with : " + dashboardAmount);
        List<Dashboard> dashboards = new ArrayList<Dashboard>();
        for (int i = 0; i < dashboardAmount; i++) {
            Dashboard dashboard = this.getRandomDashboard();
            if (this.checkValidDashboard(players, dashboard)) {
                dashboards.add(dashboard);
            }
        }
        log.info("getNewDashboards and return : " + dashboards);
        return dashboards;
    }

    @Override
    public boolean checkValidDashboard(List<Player> players, Dashboard dashboard) {
        // TODO: ARE - check different dashboard values
        return true;
    }

    @Override
    public Dashboard getRandomDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setLines(this.getDashboardLines());
        return dashboard;
    }

    @Override
    public List<DashboardsLines> getDashboardLines() {
        List<DashboardsLines> dashboardsLines = new ArrayList<DashboardsLines>();
        for (int i = 0; i < 3; i++) {
            this.getNewDashboardLine(dashboardsLines);
        }
        return dashboardsLines;
    }

    @Override
    public void getNewDashboardLine(List<DashboardsLines> dashboardsLines) {
        dashboardsLines.add(new DashboardsLines());
        List<Integer> colValues = this.getLineBaseValues();
        this.getDashboardLinesValues(dashboardsLines, colValues);
    }

    @Override
    public List<Integer> getLineBaseValues() {
        int colValuesLenght = 5;
        List<Integer> colValues = new ArrayList<Integer>();
        for (int i = 0; i < colValuesLenght; i++) {
            Integer colValue;
            do {
                colValue = this.getRandomInt(9);
            } while (colValues.contains(colValue));
            colValues.add(colValue);
        }
        Collections.sort(colValues);
        return colValues;
    }

    @Override
    public void getDashboardLinesValues(List<DashboardsLines> dashboardsLines, List<Integer> colValues) {
        List<Integer> lineValues = new ArrayList<Integer>();
        for (int i = 0; i < colValues.size(); i++) {
            Integer value;
            do {
                value = (colValues.get(i) * 10) + this.getRandomInt(10);
                // value = i;
            } while (this.checkValidValue(dashboardsLines, lineValues, value));
            this.addValue(dashboardsLines, lineValues, value);
        }
        dashboardsLines.get(dashboardsLines.size() - 1).setValues(lineValues);
    }

    @Override
    public boolean checkValidValue(List<DashboardsLines> dashboardsLines, List<Integer> lineValues, Integer value) {
        if (lineValues.contains(value)) {
            return true;
        } else {
            for (DashboardsLines line : dashboardsLines) {
                if (line.getValues().contains(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public void addValue(List<DashboardsLines> dashboardsLines, List<Integer> lineValues, Integer value) {
        Integer newValue = value;
        for (DashboardsLines line : dashboardsLines) {
            int valueDecent = value / 10;
            Integer match = line.getValues().stream()
                    .filter(oldValue -> (oldValue / 10) == valueDecent && value < oldValue)
                    .findFirst()
                    .orElse(null);
            if (null != match) {
                // TODO: ARE - El orden no es perfecto. La tercera línea pude cambiar la
                // primera. pero puede haber un segundo valor intermedio
                newValue = match;
                log.info("Replace " + match + " for: " + value);
                line.getValues().set(line.getValues().indexOf(match), value);
                log.info(line.getValues());
                log.info("Replace " + match + " for: " + value);
                break;
            }
        }
        lineValues.add(newValue);
        log.info(lineValues);
    }

    @Override
    public List<Player> getDummyPlayers(List<Player> players) {
        return players.stream()
                .filter(player -> player.isDummy())
                .collect(Collectors.toList());
    }

    @Override
    public void getRoundNewValue(Round round) {
        Integer newValue = 0;
        do {
            newValue = this.getRandomDashboardValue();
        } while (this.checkValidValue(newValue, round.getValues()));
        round.setNewValue(newValue);
        round.getValues().add(newValue);
    }

    @Override
    public boolean checkValidValue(Integer newValue, List<Integer> values) {
        return values.contains(newValue);
    }
}
