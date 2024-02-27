package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


@Getter
public class Board {
    private int size;
    private List<List<Cell>> cells= new ArrayList<>();
    public Board(Integer size){
        this.size=size;
        this.cells =initialiseCells(size);
    }
    private List<List<Cell>> initialiseCells(Integer size){
        List<List<Cell>> cells =new ArrayList<>();
        IntStream.range(0,size).forEach(row->{
            List<Cell> rowCells = new ArrayList<>();
            IntStream.range(0,size).forEach(col ->rowCells.add(Cell.builder()
                    .row(row)
                    .column(col).build()));
            cells.add(rowCells);
        });
        return cells;
    }
    public boolean isEmpty(Integer row,Integer column){
        return cells.get(row).get(column).getSymbol()==null;
    }
    public Cell getBoradCell(int row,int col){
       return cells.get(row).get(col);
    }
    public void update(Cell move){
        int row=move.getRow();
        int col=move.getColumn();
        getBoradCell(row,col).setSymbol(move.getSymbol());
    }
    public List<Cell> getEmptyCells(){
        return cells.stream()
                    .flatMap(List::stream)
                    .filter(cell -> cell.getSymbol()==null)
                    .collect(toList());
    }
    public void printBoard(){
        for(int i=0;i<cells.size();++i){
            for(int j=0;j<cells.size();++j){
                GameSymbol symbol =cells.get(i).get(j).getSymbol();
                if(symbol==null){
                    System.out.printf("| - |");
                }else{
                    System.out.print("| "+symbol+" |");
                }
            }
            System.out.printf("\n");
        }
    }
}
