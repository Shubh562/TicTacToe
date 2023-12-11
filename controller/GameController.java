package controller;

import exception.BotCountException;
import exception.PlayerCountDimensionMisMatchException;
import exception.SymbolCountException;
import model.Game;
import model.GameState;
import model.Player;
import strategies.winning.WinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension,
                          List<Player> players,
                          List<WinningStrategy> winningStrategies) throws PlayerCountDimensionMisMatchException, BotCountException, SymbolCountException {
        return Game.getBuilder()
                .setDimensions(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }
    public void makeMove(Game game){
        game.makeMove();
    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public GameState checkState(Game game){
    return game.getGameState();
    }
    public void undo(Game game){

    }
}
