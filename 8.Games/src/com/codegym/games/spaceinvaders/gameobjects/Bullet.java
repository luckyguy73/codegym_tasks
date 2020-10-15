package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.games.spaceinvaders.Direction;
import com.codegym.games.spaceinvaders.ShapeMatrix;

public class Bullet extends GameObject {
    private int dy;
    public boolean isAlive = true;

    public Bullet(double x, double y, Direction direction) {
        super(x, y);
        super.setMatrix(ShapeMatrix.BULLET);
        dy = direction == Direction.UP ? -1 : 1;
    }

    public void move() {
        y += dy;
    }

    public void kill() {
        isAlive = false;
    }
}
