package Scaler.systemdesign.module3.tictactao.designPatterns.WinningStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;

import java.util.List;
import java.util.stream.Collectors;

public class RightDiagonalWinningStrategy implements WinningStrategy{
    private static final int subtractBy=1;
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        long count= board.getCells().stream()
                .flatMap(List::stream)
                .filter(cell -> (cell.getRow() + cell.getColumn())==board.getSize()-subtractBy && cell.getSymbol() == gameSymbol).count();
        return count==board.getSize();
    }
}
