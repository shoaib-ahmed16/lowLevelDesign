package Scaler.systemdesign.module3.tictactao.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
public class Board {
    private int size;
    private List<List<Cell>> cells= new ArrayList<>();
    public Board(Integer size){
        this.size=size;
        this.cells =initialiseCells(size);
    }
    private List<List<Cell>> initialiseCells(Integer size){
        List<Cell> cellRow =Collections.nCopies(size,new Cell());
        return Collections.nCopies(size,cellRow);
    }
    public boolean isEmpty(Integer row,Integer column){
        return cells.get(row).get(column)==null;
    }
    public Cell getCell(int row,int col){
        return cells.get(row).get(col);
    }
    public void update(Cell move){
        int row=move.getRow();
        int col=move.getColumn();
        Cell cell= getCell(row,col);
        cell.builder()
                .row(row)
                .column(col)
                .symbol(move.getSymbol())
                .build();
    }
}
