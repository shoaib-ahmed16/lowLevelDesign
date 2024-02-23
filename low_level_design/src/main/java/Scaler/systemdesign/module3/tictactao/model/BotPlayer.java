package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameLevel;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import Scaler.systemdesign.module3.tictactao.service.PlayerStrategy;
import lombok.*;

@Getter
@Setter
public class BotPlayer extends Player{
    private GameLevel level;
    private PlayerStrategy playerStrategy;

    public BotPlayer(GameSymbol symbol,GameLevel level,PlayerStrategy strategy) {
        super(symbol);
        this.level=level;
        this.playerStrategy=strategy;
    }

    @Override
    public void play() {

    }
}
