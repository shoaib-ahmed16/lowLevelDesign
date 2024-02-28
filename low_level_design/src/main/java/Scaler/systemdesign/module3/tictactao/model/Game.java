package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.designPatterns.WinningStrategy.*;
import Scaler.systemdesign.module3.tictactao.exception.InvalidMoveException;
import Scaler.systemdesign.module3.tictactao.model.enums.GameStatus;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

import static java.util.stream.Collectors.toSet;

@Data
@AllArgsConstructor
public class Game {
    private static final int PLAYER_COUNT=2;
    private static GameStatus DEFAULT_STATUS=GameStatus.IN_PROGRESS;
    private Board board;
    private List<Player> players= new ArrayList<>() ;
    private GameStatus status;
    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(),new LeftDiagonalWinningStrategy(),new RightDiagonalWinningStrategy(),new ColumnWinningStrategy());
    private int nextPlayerIndex;
    private  Player winner;
    public void start(){
        // Assign a random value to the next PlayerIndex
        // Random value -> 0 or 1
        // 0.5 * 2 = 1.0 = 1;
        // 0.1 * 2 = 0.2 = 0;
        // 0.8 * 2 = 1.6 = 1;
        nextPlayerIndex=(int) Math.random() *players.size();
        status =GameStatus.IN_PROGRESS;
    }

    public void makeMove(){
        Cell move=getNextMove();
        board.update(move);

        if(checkWinner(move.getSymbol())){
            status =GameStatus.FINISHED;
            winner=getNextPlayer();
            return;
        }
        if(checkDraw()){
            status=GameStatus.DRAWN;
            System.out.println("Game is a Draw");
            return;
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

    private boolean checkWinner(GameSymbol symbol){
        // Implement check rows
        for(WinningStrategy strategy:winningStrategies){
            boolean hasWinner=strategy.checkWinner(board,symbol);
            if(hasWinner){
                return true;
            }
        }
        return false;
    }
    private boolean checkDraw(){
        List<Cell> emptyCells=board.getEmptyCells();
        return emptyCells.isEmpty() && getStatus()==GameStatus.IN_PROGRESS;
    }
    public void undo(){

    }

    private Game(){
        // Sequence of moves -> Stack of moves
        Stack<Cell> moves;

        // Remove from the stack
        // Set the player to null on the board

        //update the next player index

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
    public Player getNextPlayer(){
        return players.get(nextPlayerIndex);
    }
}
