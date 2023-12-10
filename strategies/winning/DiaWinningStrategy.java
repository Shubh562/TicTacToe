package strategies.winning;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiaWinningStrategy implements WinningStrategy{
    private Map<Symbol, Integer> diagonal=new HashMap<>();
    private Map<Symbol, Integer> reverseDiagonal=new HashMap<>();


    @Override
    public Boolean getWinner(Move move, Board board) {
        Cell cell= move.getCell();
        Player player= move.getPlayer();
        int row= cell.getRow();
        int col= cell.getCol();
        if(row==col) {
            diagonal.put(player.getSymbol(),diagonal.getOrDefault(player.getSymbol(),0)+1);
        }
        if(row+col==board.getSize()-1){
            reverseDiagonal.put(player.getSymbol(),diagonal.getOrDefault(player.getSymbol(),0)+1);
        }
        return diagonal.get(player.getSymbol())== board.getSize() || reverseDiagonal.get(player.getSymbol())== board.getSize();
    }
}
