package are.bingo.models;

import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Round {

    private Integer newValue;

    private List<Integer> values = new ArrayList<Integer>();

    private RoundStatusEnum status = RoundStatusEnum.PLAYING;

    private Boolean line = false;

    private Boolean bingo = false;
}
