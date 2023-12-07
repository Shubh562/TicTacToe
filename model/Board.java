package model;

import java.util.List;

public class Board {
    private int size;
    private List<Cell> board;

    public int getSize() {
        return size;
    }
    Board(int dimension){
        size=dimension;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Cell> getBoard() {
        return board;
    }

    public void setBoard(List<Cell> board) {
        this.board = board;
    }
}
