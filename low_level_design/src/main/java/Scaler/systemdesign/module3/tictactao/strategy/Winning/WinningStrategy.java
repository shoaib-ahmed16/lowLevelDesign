package Scaler.systemdesign.module3.tictactao.strategy.Winning;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;

public interface WinningStrategy {
   boolean checkWinner(Board board, GameSymbol gameSymbol);
}
