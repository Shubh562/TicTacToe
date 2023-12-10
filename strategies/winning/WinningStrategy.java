package strategies.winning;

import model.Board;
import model.Game;
import model.Move;


public interface WinningStrategy {
    public Boolean getWinner(Move move, Board board);

}
