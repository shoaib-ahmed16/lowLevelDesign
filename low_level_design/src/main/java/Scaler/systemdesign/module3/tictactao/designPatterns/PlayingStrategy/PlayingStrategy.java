package Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;

public interface PlayingStrategy {
    Cell makeMove(Board board);
}
