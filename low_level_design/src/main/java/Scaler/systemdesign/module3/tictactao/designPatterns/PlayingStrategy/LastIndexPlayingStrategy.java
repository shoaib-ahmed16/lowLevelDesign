package Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

import java.util.List;

public class LastIndexPlayingStrategy implements PlayerStrategy{
    private static  final int subtractBy=1;
    @Override
    public Cell makeMove(Board board) {
        List<Cell> emptyCells =board.getEmptyCells();
        Cell boardCell=emptyCells.get(emptyCells.size()-subtractBy);
        return   Cell.builder()
                .row(boardCell.getRow())
                .column(boardCell.getColumn())
                .build();
    }
}
