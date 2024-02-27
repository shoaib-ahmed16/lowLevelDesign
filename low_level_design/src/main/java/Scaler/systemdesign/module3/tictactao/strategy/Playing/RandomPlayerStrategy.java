package Scaler.systemdesign.module3.tictactao.strategy.Playing;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;
import Scaler.systemdesign.module3.tictactao.strategy.Playing.PlayerStrategy;

import java.util.List;

public class RandomPlayerStrategy implements PlayerStrategy {
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
