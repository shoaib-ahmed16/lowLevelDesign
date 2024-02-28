package Scaler.systemdesign.module3.tictactao.designPatterns.WinningStrategy;

import Scaler.systemdesign.module3.tictactao.model.Board;
import Scaler.systemdesign.module3.tictactao.model.Cell;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        //Check if all the symbols in the same row are the same
        for(List<Cell> rows: board.getCells()){
            boolean isWinner = true;
            for(Cell cell:rows){
                if(cell.getSymbol()!=gameSymbol){
                    isWinner=false;
                }
            }
            if (isWinner){
                return true;
            }
        }
        return false;
    }
}
