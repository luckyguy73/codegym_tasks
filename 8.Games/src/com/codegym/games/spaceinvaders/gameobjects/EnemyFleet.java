package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.engine.cell.Game;
import com.codegym.games.spaceinvaders.*;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private Direction direction = Direction.RIGHT;
    private List<EnemyShip> ships;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int x = 0; x < COLUMNS_COUNT; ++x)
            for (int y = 0; y < ROWS_COUNT; ++y) ships.add(new EnemyShip(x * STEP, y * STEP + 12));
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2.0 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2.0 - 1, 5));
    }

    public void draw(Game game) {
        ships.forEach(e -> e.draw(game));
    }

    private double getLeftBorder() {
        return ships.stream().mapToDouble(m -> m.x).min().orElse(0);
    }

    private double getRightBorder() {
        return ships.stream().mapToDouble(m -> m.x + m.width).max().orElse(SpaceInvadersGame.WIDTH);
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public void move() {
        if (ships.size() == 0) return;
        boolean changed = false;
        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            changed = true;
        }
        else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            changed = true;
        }
        Direction d = changed ? Direction.DOWN : direction;
        double s = getSpeed();
        ships.forEach(f -> f.move(d, s));
    }

    public Bullet fire(Game game) {
        if (ships.size() == 0 || game.getRandomNumber(100 / SpaceInvadersGame.DIFFICULTY) > 0) return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public int checkHit(List<Bullet> bullets) {
        if (bullets.size() < 1) return 0;
        int total = 0;
        for (EnemyShip ship : ships) {
            if (!ship.isAlive) continue;
            for (Bullet bullet : bullets) {
                if (!bullet.isAlive) continue;
                if (ship.isCollision(bullet)) {
                    ship.kill();
                    total += ship.score;
                    bullet.kill();
                }
            }
        }
        return total;
    }

    public void deleteHiddenShips() {
        ships.removeIf(s -> !s.isVisible());
    }

    public double getBottomBorder() {
        return ships.stream().mapToDouble(s -> s.y + s.height).max().orElse(0.0);
    }

    public int getShipCount() {
        return ships.size();
    }

}
