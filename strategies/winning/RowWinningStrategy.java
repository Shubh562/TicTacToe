package strategies.winning;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    private List<Map<Symbol,Integer>> cols;

    public RowWinningStrategy(int n){
        cols=new ArrayList<>();
        for(int i=0;i<n;i++){
            cols.add(new HashMap<>());
        }
    }
    @Override
    public Boolean getWinner(Move move, Board board) {
        Cell cell= move.getCell();
        Player player= move.getPlayer();
        int col= cell.getCol();
        Map<Symbol,Integer> rowMap=cols.get(col);
        rowMap.put(player.getSymbol(),rowMap.getOrDefault(player.getSymbol(),0)+1);
        return rowMap.get(player.getSymbol())== board.getSize();
    }
}
