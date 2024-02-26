package Scaler.systemdesign.module3.tictactao.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidPlayersException extends RuntimeException{
    public InvalidPlayersException(String message){
        super(message);
    }
}
