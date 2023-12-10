import controller.GameController;
import exception.BotCountException;
import exception.PlayerCountDimensionMisMatchException;
import exception.SymbolCountException;
import model.Game;
import model.GameState;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws PlayerCountDimensionMisMatchException, BotCountException, SymbolCountException {
        GameController gameController=new GameController();
        System.out.println("Game is Starting");
        Game game=gameController.startGame(3,new ArrayList<>(),new ArrayList<>());
        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
           }
        if(gameController.checkState(game).equals(GameState.SUCCESS)){
            System.out.println("Winner is some Player");
        } else if (gameController.checkState(game).equals(GameState.DRAW)) {
            System.out.println("Game id Drawn");
        }
    }
}
