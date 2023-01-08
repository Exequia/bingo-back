package are.bingo.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DashboardsLines {
    String status = "standard";
    List<Integer> values = new ArrayList<Integer>();
}
