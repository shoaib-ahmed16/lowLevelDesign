package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.*;

@Getter
@Setter
public class HumanPlayer extends Player{
    private String sessionId;
    private String colour;
    private User user;

    public HumanPlayer(GameSymbol symbol,String sessionId,String colour,User user) {
        super(symbol);
        this.colour=colour;
        this.sessionId=sessionId;
        this.user=user;
    }

    @Override
    public void play() {

    }
}
