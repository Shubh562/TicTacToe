import controller.GameController;
import exception.BotCountException;
import exception.PlayerCountDimensionMisMatchException;
import exception.SymbolCountException;
import model.*;
import strategies.winning.ColWinningStrategy;
import strategies.winning.DiaWinningStrategy;
import strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws PlayerCountDimensionMisMatchException, BotCountException, SymbolCountException {
        GameController gameController=new GameController();
        Player shubham=new Player("Shubham",1, new Symbol('X'), PlayerType.HUMAN);
        Player bot = new Bot("Bourvita", 3, new Symbol('Y'), PlayerType.BOT, BotDifficultyLevel.EASY);
        RowWinningStrategy r=new RowWinningStrategy(3);
        ColWinningStrategy c=new ColWinningStrategy(3);
        DiaWinningStrategy d=new DiaWinningStrategy();
        System.out.println("Game is Starting");
        Game game=gameController.startGame(3,Arrays.asList(shubham, bot), Arrays.asList(r,c,d));
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
           }
        if(gameController.checkState(game).equals(GameState.ENDED)){
            Player winner = gameController.getWinner(game);
            System.out.println("Winner is " + winner.getName());
        } else if (gameController.checkState(game).equals(GameState.DRAW)) {
            System.out.println("Game id Drawn");
        }
    }
}
