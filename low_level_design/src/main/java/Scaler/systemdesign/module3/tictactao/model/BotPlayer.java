package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameLevel;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy.PlayerStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotPlayer extends Player{
    private GameLevel level;
    private PlayerStrategy playerStrategy;
    private static final  String name="Chitti";

    public BotPlayer(GameSymbol symbol,GameLevel level,PlayerStrategy strategy) {
        super(symbol,name);
        this.level=level;
        this.playerStrategy=strategy;
    }

    @Override
    public Cell makeMove(Board board) {
        Cell boardCell= playerStrategy.makeMove(board);
        boardCell.setSymbol(getSymbol());
        return boardCell;
    }
}
