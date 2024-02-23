package Scaler.systemdesign.module3.tictactao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
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
}
