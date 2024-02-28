package Scaler.systemdesign.module3.tictactao.controller;

import Scaler.systemdesign.module3.tictactao.designPatterns.PlayingStrategy.*;
import Scaler.systemdesign.module3.tictactao.model.*;
import Scaler.systemdesign.module3.tictactao.model.enums.GameLevel;
import Scaler.systemdesign.module3.tictactao.model.enums.GameStatus;
import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Client Code
public class TicTacToe {
    private static final int boardSize=3;

    private static  final int playersPerGame=2;
    private static  List<Player> players = new ArrayList<>();
    private static Scanner inputTaker = new Scanner(System.in);
    public static void main(String[] args) {
        // Ask For user Input - name, email, and Symbol
        System.out.println("Welcome to TicTacToe");

        //Create a game
        Game game =createGame(getPlayerList());
        // Start game
        game.start();

        // Iteratively call make move
        // Until -> Game is WON or DRAWN
        while (game.getStatus()== GameStatus.IN_PROGRESS){
            Player player = game.getNextPlayer();
            System.out.println("Player Name: " + player.getName());
            System.out.println("Player Symbol: " + player.getSymbol());
            System.out.println("Make your move!!!");
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
    public static List<Player> getPlayerList(){
        System.out.println("Choose Type of Game:");
        System.out.println("1: H vs H");
        System.out.println("0: H vs Bot");
        int gameType =Integer.parseInt(inputTaker.nextLine());
        int playerNumber=1;
        if(gameType==1){
            while(playerNumber<=playersPerGame) {
                players.add(getPlayer(playerNumber));
                playerNumber++;
            }
        }else if(gameType==0){
            while(playerNumber<playersPerGame) {
                players.add(getPlayer(playerNumber));
                playerNumber++;
            }
            System.out.println("Enter the Bot level: ");
            System.out.println(" EASY,\n" +
                    "    AVERAGE,\n" +
                    "    MEDIUM,\n" +
                    "    CHALLENGING,\n" +
                    "    HARD;");
            GameLevel gameLevel= GameLevel.valueOf(inputTaker.nextLine().toUpperCase());
            players.add(new BotPlayer(decideOpponentPlayerSymbol(players.get(0).getSymbol()), gameLevel,getPlayerStrategy(gameLevel)));
        }
        return players;
    }
    public static  Player getPlayer(Integer playerNumber){
        System.out.println("Enter "+playerNumber+" Player Name:");
        String name= inputTaker.nextLine();
        System.out.println("Enter "+playerNumber+" Player Email:");
        String email = inputTaker.nextLine();
        GameSymbol symbol;
        if(playerNumber!=playersPerGame) {
            System.out.println("Choose Symbol : X or O");
            try {
                symbol = GameSymbol.valueOf(inputTaker.nextLine().toUpperCase());
            } catch (IllegalArgumentException i) {
                System.out.println("Invalid Symbol Choose.");
                return null;
            }
        }else{
            symbol= decideOpponentPlayerSymbol(players.get(0).getSymbol());
        }
        User user= new User(name,email,null);
        return new HumanPlayer(symbol,user);
    }
    private static Game createGame(List<Player> player){
        return player.stream()
                .reduce(Game.builder().withSize(boardSize), Game.Builder::withPlayer, (left, right) -> left)
                .build();

    }
    private static GameSymbol decideOpponentPlayerSymbol(GameSymbol symbol){
        if (symbol==GameSymbol.O){
            return GameSymbol.X;
        }
        return GameSymbol.O;
    }
    public static PlayingStrategy getPlayerStrategy(GameLevel level){
        return switch (level){
            case EASY -> new FirstIndexPlayingStrategy();
            case AVERAGE -> new LastIndexPlayingStrategy();
            case MEDIUM ->  new MinMaxIndexPlayingStrategy();
            case CHALLENGING ->  new AveragePlayingStrategy();
            case HARD ->new RandomPlayerStrategy();
        };
    }
}
