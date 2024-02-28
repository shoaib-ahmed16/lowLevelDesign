package Scaler.systemdesign.module3.tictactao.model;

import Scaler.systemdesign.module3.tictactao.model.enums.GameSymbol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class HumanPlayer extends Player{
    private User user;
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(GameSymbol symbol,User user) {
        super(symbol,user.getName());
        this.user=user;
    }

    @Override
    public Cell makeMove(Board board) {
        System.out.println("Enter row :");
        int row = scanner.nextInt();
        System.out.println("Enter Column :");
        int col=scanner.nextInt();
        return Cell.builder()
                .row(row)
                .column(col)
                .symbol(getSymbol())
                .build();
    }
}
