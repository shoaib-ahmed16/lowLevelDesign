package Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

import java.util.List;

public class FirstIndexPlayingStrategy implements PlayingStrategy {
    private static  final int firstIndex=0;
    @Override
    public Cell makeMove(Board board) {
        List<Cell> emptyCells =board.getEmptyCells();
        Cell boardCell=emptyCells.get(firstIndex);
        return   Cell.builder()
                .row(boardCell.getRow())
                .column(boardCell.getColumn())
                .build();
    }
}
