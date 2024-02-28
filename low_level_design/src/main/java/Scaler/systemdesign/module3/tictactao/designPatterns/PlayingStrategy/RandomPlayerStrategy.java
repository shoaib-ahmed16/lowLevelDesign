package Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

import java.util.List;

public class RandomPlayerStrategy implements PlayingStrategy {
    @Override
    public Cell makeMove(Board board){

        List<Cell> emptyCells = board.getEmptyCells();

        int randomIndex =(int) (Math.random() * emptyCells.size());

        Cell boardCell = emptyCells.get(randomIndex);

        return Cell.builder()
                .row(boardCell.getRow())
                .column(boardCell.getColumn())
                .build();
    }
}
