package design.level.low.lldDesigns.tictactoe;

import design.level.low.lldDesigns.tictactoe.domain.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public TicTacToeGame(){
        initializeGame();
    }
    public  void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1= new Player("Player1",crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2= new Player("Player2",noughtsPiece);

        players.add(player1);
        players.add(player2);
        gameBoard= new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn  =players.removeFirst();
            List<int[]> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }
            gameBoard.printBoard();
            System.out.println("Player: "+playerTurn.getName()+" Enter row, column: ");
            Scanner sc = new Scanner(System.in);
            String s=sc.nextLine();
            String[] values =s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);

            boolean pieceAddSuccessfully = gameBoard.addPiece(row,col,playerTurn.getPlayingPiece());
            if(!pieceAddSuccessfully){
                System.out.println("In Correct position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner =isThereWinner(row,col,playerTurn.getPlayingPiece().pieceType);
            if(winner){
                finalBoard();
                return playerTurn.getName();
            }
        }
        finalBoard();
        return "tie";
    }

   public boolean isThereWinner(int row, int col, PieceType pieceType){
        boolean rowMatch = true;
        boolean colMatch =true;
        boolean diagonalMatch=true;
        boolean antiDiagonalMatch=true;
        for(int i=0;i<gameBoard.boardMatrixSize;i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType !=pieceType){
                rowMatch=false;
            }
        }
       for(int i=0;i<gameBoard.boardMatrixSize;i++){
           if(gameBoard.board[i][col]==null || gameBoard.board[i][col].pieceType !=pieceType){
               colMatch=false;
           }
       }

       for(int i=0;i<gameBoard.boardMatrixSize;i++){
           if(gameBoard.board[i][i]==null || gameBoard.board[i][i].pieceType !=pieceType){
               diagonalMatch=false;
           }
       }

       for(int i=0,j=gameBoard.boardMatrixSize-1;i<gameBoard.boardMatrixSize;i++,j--){
           if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType !=pieceType){
               antiDiagonalMatch=false;
           }
       }

       return  rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;

   }
   public void finalBoard(){
       System.out.println("------------------------------");
       gameBoard.printBoard();
       System.out.println("------------------------------");
   }
}
