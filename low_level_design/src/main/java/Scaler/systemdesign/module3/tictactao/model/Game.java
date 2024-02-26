package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.exception.InvalidMoveException;
import Scaler.systemdesign.module3.tictactao.model.enums.GameStatus;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
@AllArgsConstructor
public class Game {
    private static final int PLAYER_COUNT=2;
    private static GameStatus DEFAULT_STATUS=GameStatus.IN_PROGRESS;
    private Board board;
    private List<Player> players= new ArrayList<>() ;
    private GameStatus status;
    private int nextPlayerIndex;
    public void start(){
        // Assign a random value to the next PlayerIndex

    }

    public void makeMove(){
        // Get the next Move
        Cell move=getNextMove();
        board.update(move);

        //Check for a winner
        if(checkWinner()!=null){
            status =GameStatus.FINISHED;
        }
        if(checkDraw()){
            status=GameStatus.DRAWN;
        }

        nextPlayerIndex =(nextPlayerIndex +1) % players.size();


    }

    private  Cell getNextMove(){
        Cell move=players.get(nextPlayerIndex).makeMove(board);
        validateMove(move);
        return move;
    }
    private void validateMove(Cell move){
      if(!board.isEmpty(move.getRow(),move.getColumn())){
          throw new InvalidMoveException("Invalid move as Cell is already Filled for Indexes { row:"+move.getRow()+", column: "+move.getColumn());
      }
    }

    private Player checkWinner(){
        return null;
    }
    private boolean checkDraw(){
        return false;
    }

    private Game(){

    }
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Game game;
        private Builder(){
            game=new Game();
        }

        public Builder withSize(int size){
            this.game.board= new Board(size);
            return this;
        }
        public Builder withPlayer(Player player){
            this.game.getPlayers().add(player);
            return this;
        }
        public Game build(){
            boolean isValid= validate();
            if(!isValid){
                throw new RuntimeException("InValid List Of Players!");
            }
            Game newGame = new Game();
            newGame.board=game.board;
            newGame.players =game.players;
            newGame.status=DEFAULT_STATUS;
            return newGame;
        }
        private boolean validate(){
            List<Player> playerList=this.game.players;
            if(playerList.size()!=PLAYER_COUNT){
                return false;
            }
            // If Symbols are unique
            Set<GameSymbol> symbols= playerList.stream().map(Player::getSymbol).collect(toSet());
            return symbols.size()==PLAYER_COUNT;
        }

    }
}
