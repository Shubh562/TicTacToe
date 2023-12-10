package model;

import exception.BotCountException;
import exception.PlayerCountDimensionMisMatchException;
import exception.SymbolCountException;
import strategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private int currentPlayerIndex;

    private List<WinningStrategy> winningStrategies;
    private Player winner;



    public static class Builder{
        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Builder addPlayer(Player player){
            this.players.add(player);
            return this;
        }
        public Builder addWinningStrategy(WinningStrategy winningStrategy){
            this.winningStrategies.add(winningStrategy);
            return this;
        }
        private void validateBotCount() throws BotCountException{
            int botCount=0;
            for(Player p: players){
                if(p.getPlayerType().equals(PlayerType.BOT)){
                    botCount+=1;
                }
            }
            if(botCount>1){
                throw new BotCountException();
            }
        }
        private void validatePlayerCount() throws PlayerCountDimensionMisMatchException{
            if(players.size()!=dimensions-1)
            {
                throw new PlayerCountDimensionMisMatchException();
            }
        }

        private void validateSymbolCount() throws SymbolCountException{
            //validate diff symbol for every player
            Map<Character,Integer> symCount=new HashMap<>();
            for(Player p: players){
                if(!symCount.containsKey(p.getSymbol().getaChar())){
                    symCount.put(p.getSymbol().getaChar(),0);
                }
                symCount.put(p.getSymbol().getaChar(),
                        symCount.get(p.getSymbol().getaChar())+1);
                if(symCount.get(p.getSymbol().getaChar())>1){
                    throw new SymbolCountException();
                }
            }
        }
        private void validate() throws BotCountException,PlayerCountDimensionMisMatchException, SymbolCountException{

           validateBotCount();
           validatePlayerCount();
           validateSymbolCount();

        }
        public Game build() throws BotCountException,PlayerCountDimensionMisMatchException, SymbolCountException{
            validate();
            return new Game(
                    this.dimensions,
                    this.players,
                    this.winningStrategies
            );
        }
    }
    private Game(int dimensions, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players=players;
        this.winningStrategies=winningStrategies;
        this.moves=new ArrayList<>();
        this.currentPlayerIndex =0;
        this.gameState=GameState.IN_PROGRESS;
        this.board=new Board(dimensions);
    }
    public void displayBoard(){
         this.board.displayBoard();
    }
    public void makeMove(){
        Player currentPlayer = players.get(currentPlayerIndex);
        Move move=currentPlayer.makeMove(board);
        //Ask the player to tell which cell to move on
        moves.add(move);
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return this.players;
    }

    public void setPlayer(List<Player> player) {
        this.players = player;
    }

    public List<Move> getMove() {
        return moves;
    }

    public void setMove(List<Move> move) {
        this.moves = move;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
