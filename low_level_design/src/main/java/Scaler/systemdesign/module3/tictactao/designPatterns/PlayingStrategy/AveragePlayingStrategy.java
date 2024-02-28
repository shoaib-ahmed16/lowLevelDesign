package Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

import java.util.List;

public class AveragePlayingStrategy implements PlayingStrategy {
    private int averageIndex;
    private static final int  divisor=2;
    @Override
    public Cell makeMove(Board board){
        List<Cell> emptyCells =board.getEmptyCells();
        averageIndex= emptyCells.size() /divisor;
        Cell boardCell=emptyCells.get(averageIndex);
        return   Cell.builder()
                .row(boardCell.getRow())
                .column(boardCell.getColumn())
                .build();
    }
}
