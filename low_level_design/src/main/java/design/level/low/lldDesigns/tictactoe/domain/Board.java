package design.level.low.lldDesigns.tictactoe.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int boardMatrixSize;

    public PlayingPiece[][] board;
    public Board(int size){
        this.boardMatrixSize=size;
        board= new PlayingPiece[this.boardMatrixSize][this.boardMatrixSize];
    }

    public boolean addPiece(int row,int column,PlayingPiece playingPiece){
        if(row>=boardMatrixSize || column >=boardMatrixSize){
            return false;
        }
        if(board[row][column]!=null){
            return false;
        }
        board[row][column] =playingPiece;
        return true;
    }

    public  void printBoard(){
        for(int i=0;i<boardMatrixSize;i++){
            for(int j=0;j<boardMatrixSize;j++){
                if(board[i][j]!=null)
                    System.out.print(board[i][j].pieceType+" | ");
                else{
                    System.out.print("  | ");
                }
            }
            System.out.println("\n");
        }
    }
    public List<int[]> getFreeCells(){
        List<int[]> freeSpaces= new ArrayList<>();
        for(int i=0;i<boardMatrixSize;i++){
            for(int j=0;j<boardMatrixSize;j++){
                if(board[i][j]==null)
                    freeSpaces.add(new int[]{i,j});
            }
        }
        return  freeSpaces;
    }
}
