package are.bingo.services.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import are.bingo.models.Game;
import are.bingo.models.RoundStatusEnum;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PlayRound extends Thread implements IPlayRound {

    private UtilsService utilsService;
    private Integer gameRoundTimeSleep;
    private SimpMessagingTemplate template;
    private Game game;

    public PlayRound() {
    };

    public PlayRound(UtilsService utilsService, Integer gameRoundTimeSleep, SimpMessagingTemplate template, Game game) {
        this.utilsService = utilsService;
        this.gameRoundTimeSleep = gameRoundTimeSleep;
        this.template = template;
        this.game = game;
    }

    public void run() {
        try {
            this.startGameRound();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    @Override
    public void emitGameRound() throws Exception {
        this.template.convertAndSend("/topic/game/round", this.game.getRound());
    }

    @Override
    public void startGameRound() throws Exception {
        log.info("start Game Round - start");
        do {
            this.utilsService.getRoundNewValue(this.game.getRound());
            this.emitGameRound();
            log.info("start Game Round - create new value: " + this.game.getRound().getNewValue());
            Thread.sleep(this.gameRoundTimeSleep);
        } while (this.game.getRound().getStatus() == RoundStatusEnum.PLAYING
                || this.game.getRound().getValues().size() <= 90);
        log.info("start Game Round - end");
    }

}
