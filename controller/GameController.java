package controller;

import model.Game;
import model.GameState;
import model.Player;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {
    public void startGame(int dimension,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) {
        Game.getBuilder()
                .setDimensions(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }
    public void makeMove(Game game){

    }
    public void displayBoard(Game game){

    }
    public void getWinner(Game game){

    }
    public GameState checkState(Game game){
    return game.getGameState();
    }
    public void undo(Game game){

    }
}
