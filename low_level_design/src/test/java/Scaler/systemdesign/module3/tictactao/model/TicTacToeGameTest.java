package Scaler.systemdesign.module3.tictactao.model;

import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeGameTest {

    @DisplayName("Test case: Creating Game")
    @Test
    void testCreateGame(){
        Board board = new Board(3);
        assertEquals(3,board.getSize());
        assertEquals(3,board.getCells().size());
        assertEquals(3,board.getCells().get(0).size());
        assertTrue(board.getCells().get(0).get(0) instanceof Cell);

    }

}