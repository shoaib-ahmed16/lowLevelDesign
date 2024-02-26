package Scaler.systemdesign.module3.tictactao.strategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

public interface PlayerStrategy {
    Cell makeMove(Board board);
}