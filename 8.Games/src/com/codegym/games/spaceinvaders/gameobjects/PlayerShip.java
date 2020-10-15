package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.games.spaceinvaders.*;

import java.util.List;

public class PlayerShip extends Ship {
    private Direction direction = Direction.UP;
    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);
    }

    public void checkHit(List<Bullet> bullets) {
        if (bullets.size() == 0 || !isAlive) return;
        Bullet bullet = bullets.stream().filter(b -> b.isAlive).filter(this::isCollision).findFirst().orElse(null);
        if (bullet == null) return;
        kill();
        bullet.kill();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction == Direction.DOWN ? this.direction : direction;
    }

    public void move() {
        if (!isAlive) return;
        if (direction == Direction.LEFT) x--;
        if (direction == Direction.RIGHT) x++;
        if (x < 0) x = 0;
        if (x + width > SpaceInvadersGame.WIDTH) x = SpaceInvadersGame.WIDTH - width;
    }

    public void win() {
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }

    @Override
    public Bullet fire() {
        if (!isAlive) return null;
        return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }

    @Override
    public void kill() {
        if (!isAlive) return;
        isAlive = false;
        setAnimatedView(false, ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST, ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD, ShapeMatrix.DEAD_PLAYER);
    }
}
