package model;

import factories.BotPlayingStrategyFactory;
import strategies.botPlaying.BotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Its " + getName() + "'s turn");
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.getStrategy(botDifficultyLevel);
        Move move = strategy.makeMove(board, this);
        System.out.println("Bot made a move on row:" + move.getCell().getRow() + " col:" + move.getCell().getCol());
        return move;

    }
}
