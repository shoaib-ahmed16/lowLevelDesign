package Scaler.systemdesign.module3.tictactao.controller;

import Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy.MinMaxIndexPlayingStrategy;
import Scaler.systemdesign.module3.tictactao.model.*;
import Scaler.systemdesign.module3.tictactao.model.enums.GameLevel;
import Scaler.systemdesign.module3.tictactao.model.enums.GameStatus;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy.FirstIndexPlayingStrategy;

import java.util.Scanner;

//Client Code
public class TicTacToe {
    private static final int boardSize=3;
    private static Scanner inputTaker = new Scanner(System.in);
    public static void main(String[] args) {
        // Ask For user Input - name, email, and Symbol
        System.out.println("Welcome to TicTacToe");
        Player humanPlayer=getUserInput();

        //Create a game
        Game game =createGame(humanPlayer);
        // Start game
        game.start();

        // Iteratively call make move
        // Until -> Game is WON or DRAWN
        while (game.getStatus()== GameStatus.IN_PROGRESS){
            Player player = game.getNextPlayer();
            System.out.println("Next player: "+player.getSymbol());
            game.makeMove();
            game.getBoard().printBoard();
        }
        if(game.getStatus()==GameStatus.FINISHED){
            Player player=game.getWinner();
            if(player instanceof BotPlayer) {
                System.out.println("Game won by Bot :");
                System.out.println("Name: " + player.getName());
                System.out.println("Symbol : " + player.getSymbol());
            }
            else{
                System.out.println("Game won by Player :");
                System.out.println("Name: "+player.getName());
                System.out.println("Symbol : "+player.getSymbol());
            }
        }
    }
    public static Player getUserInput(){
        // Also ask the user for the type of bot
        // Task 1 - to take user input for the type of bot

        System.out.println("Enter Name:");
        String name= inputTaker.nextLine();
        System.out.println("Enter Email:");
        String email = inputTaker.nextLine();
        System.out.println("Choose Symbol : X or O");
        GameSymbol symbol;
        try {
             symbol = GameSymbol.valueOf(inputTaker.nextLine().toUpperCase());
        }catch (IllegalArgumentException i){
            System.out.println("Invalid Symbol Choose.");
            return null;
        }
        User user= new User(name,email,null);
        return new HumanPlayer(symbol,user);
    }
    private static Game createGame(Player player){
        // Type of game: H vs H or H vs B
        // Task 2 - Ask user input for the type of game
        return Game.builder()
                .withSize(boardSize)
                .withPlayer(player)
                // Initialise the bot Player
                .withPlayer(new BotPlayer(decideBotSymbol(player.getSymbol()), GameLevel.EASY,new MinMaxIndexPlayingStrategy()))
                .build();
    }
    private static GameSymbol decideBotSymbol(GameSymbol symbol){
        if (symbol==GameSymbol.O){
            return GameSymbol.X;
        }
        return GameSymbol.O;
    }
}
