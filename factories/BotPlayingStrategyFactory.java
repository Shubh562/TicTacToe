package factories;

import model.BotDifficultyLevel;
import strategies.botPlaying.BotPlayingStrategy;
import strategies.botPlaying.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategy(BotDifficultyLevel difficultyLevel){
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }
        return new EasyBotPlayingStrategy();
    }
}
