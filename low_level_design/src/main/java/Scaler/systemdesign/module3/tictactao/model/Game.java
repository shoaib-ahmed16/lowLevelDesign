package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Board board;
    private List<Player> players= new ArrayList<>() ;
    private GameStatus status;

    public void makeMove(){

    }
    public void start(){

    }
    private Player checkWinner(){
        return null;
    }
    private boolean checkDraw(){
        return false;
    }
}
