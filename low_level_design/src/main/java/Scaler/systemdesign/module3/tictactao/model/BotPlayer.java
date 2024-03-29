package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameLevel;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy.PlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotPlayer extends Player{
    private GameLevel level;
    private PlayingStrategy playerStrategy;
    private static final  String name="Chitti";

    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStrategy strategy) {
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
