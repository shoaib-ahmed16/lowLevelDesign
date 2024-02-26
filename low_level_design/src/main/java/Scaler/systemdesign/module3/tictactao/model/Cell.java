package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Cell {
    private Integer row;
    private Integer column;
    private GameSymbol symbol;
    public  Builder builder(){
        return new Builder();
    }
    static class Builder{
        private  Cell cell;
        private Builder(){
            cell=new Cell();
        }
        public Builder row(Integer row){
            cell.row =row;
            return this;
        }
        public Builder column(Integer column){
            cell.column =column;
            return this;
        }
        public Builder symbol(GameSymbol symbol){
            cell.symbol=symbol;
            return this;
        }
        public Cell build(){
            return cell;
        }
    }
}
