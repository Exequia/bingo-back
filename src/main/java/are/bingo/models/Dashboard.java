package are.bingo.models;

import java.util.List;

import lombok.Data;

@Data
public class Dashboard {
    String status = "standard";
    List<DashboardsLines> lines;
}
