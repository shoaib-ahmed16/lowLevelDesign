package Scaler.systemdesign.module3.tictactao.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidMoveException extends RuntimeException{
    public  InvalidMoveException(String message){
        super(message);
    }
}
