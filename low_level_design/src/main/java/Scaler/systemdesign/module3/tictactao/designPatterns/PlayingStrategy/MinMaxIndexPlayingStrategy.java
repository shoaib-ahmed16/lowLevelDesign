package Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

import java.util.List;

public class MinMaxIndexPlayingStrategy implements PlayerStrategy {
    private int value=2;
    private static  final int subtractBy=1;
    private static final int minIndex=0;

    @Override
    public Cell makeMove(Board board) {
        List<Cell> emptyCells =board.getEmptyCells();
        Cell boardCell;
        if(value % 2==0){
            boardCell=emptyCells.get(minIndex);
        }else{
            boardCell=emptyCells.get(emptyCells.size()-subtractBy);
        }
        value++;
        return   Cell.builder()
                .row(boardCell.getRow())
                .column(boardCell.getColumn())
                .build();
    }
}
