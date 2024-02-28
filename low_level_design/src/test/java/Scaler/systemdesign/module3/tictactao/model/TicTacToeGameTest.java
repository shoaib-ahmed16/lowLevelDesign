package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameLevel;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy.RandomPlayerStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeGameTest {

    private static  final int BOARD_SIZE=3;
    @DisplayName("Test case: Creating Game")
    @Test
    void testCreateGame(){
        Board board = new Board(BOARD_SIZE);
        assertEquals(BOARD_SIZE,board.getSize());
        assertEquals(BOARD_SIZE,board.getCells().size());
        assertEquals(BOARD_SIZE,board.getCells().get(0).size());
        assertTrue(board.getCells().get(0).get(0) instanceof Cell);

    }

    @DisplayName("Test case: Creating Complete Game")
    @Test
    void testCreateCompleteGame(){
        Game game = Game.builder()
                        .withSize(3)
                        .withPlayer(new HumanPlayer(GameSymbol.O,new User()))
                        .withPlayer(new BotPlayer(GameSymbol.X, GameLevel.EASY,new RandomPlayerStrategy()))
                        .build();
        assertEquals(2,game.getPlayers().size());

    }



}