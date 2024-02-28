package Scaler.systemdesign.module3.tictactao.designPatterns.WinningStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;

public interface WinningStrategy {
   boolean checkWinner(Board board, GameSymbol gameSymbol);
}
