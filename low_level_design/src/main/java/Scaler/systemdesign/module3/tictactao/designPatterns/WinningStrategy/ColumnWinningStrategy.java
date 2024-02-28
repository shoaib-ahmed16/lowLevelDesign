package Scaler.systemdesign.module3.tictactao.designPatterns.WinningStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;

import java.util.stream.IntStream;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        int size = board.getCells().size();
        return IntStream.range(0, size)
                .anyMatch(col ->
                        board.getCells().stream()
                                .map(row -> row.get(col))
                                .allMatch(cell -> cell.getSymbol() == gameSymbol)
                );
    }
}
