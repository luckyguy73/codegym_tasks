package com.codegym.games.racer;

import com.codegym.games.racer.road.RoadManager;

public class PlayerCar extends GameObject {
    private static final int playerCarHeight = ShapeMatrix.PLAYER.length;
    private Direction direction;
    public int speed = 1;

    public PlayerCar() {
        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }

    public void move() {
        if (direction == Direction.LEFT) this.x--;
        else if (direction == Direction.RIGHT) this.x++;
        if (x < RoadManager.LEFT_BORDER) x = RoadManager.LEFT_BORDER;
        else if (x > RoadManager.RIGHT_BORDER - width) x = RoadManager.RIGHT_BORDER - width;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void stop() {
        matrix = ShapeMatrix.PLAYER_DEAD;
    }
}
