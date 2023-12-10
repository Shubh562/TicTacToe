package strategies.botPlaying;

import model.Board;
import model.Bot;
import model.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board, Bot bot);
}
