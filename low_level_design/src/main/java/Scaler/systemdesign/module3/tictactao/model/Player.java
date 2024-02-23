package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Player {
    private GameSymbol symbol;
    public abstract void play();
}
