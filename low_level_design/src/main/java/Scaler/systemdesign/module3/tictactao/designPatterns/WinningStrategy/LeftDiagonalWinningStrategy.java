package Scaler.systemdesign.module3.tictactao.designPatterns.WinningStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import Scaler.systemdesign.module3.tictactao.model.Cell;

import java.util.List;
import java.util.stream.Collectors;

public class LeftDiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        long cells= board.getCells().stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getRow().equals(cell.getColumn()) && cell.getSymbol() == gameSymbol).count();
        return cells==board.getSize();
    }
}
