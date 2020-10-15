package com.codegym.games.minesweeper;

public class GameObject {
    public int countMineNeighbors;
    public int x;
    public int y;
    public boolean isMine;
    public boolean isOpen;
    public boolean isFlag;

    public GameObject(int x, int y, boolean b) {
        this.x = x;
        this.y = y;
        this.isMine = b;
    }
}
