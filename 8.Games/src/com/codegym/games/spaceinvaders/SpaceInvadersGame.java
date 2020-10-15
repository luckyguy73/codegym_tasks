package com.codegym.games.spaceinvaders;

import com.codegym.engine.cell.*;
import com.codegym.games.spaceinvaders.gameobjects.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int DIFFICULTY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private PlayerShip playerShip;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private boolean isGameStopped;
    private int animationsCount;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        drawScene();
        setTurnTimer(40);
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        enemyBullets.forEach(e -> e.draw(this));
        playerBullets.forEach(e -> e.draw(this));
        playerShip.draw(this);
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; ++x) for (int y = 0; y < HEIGHT; ++y) setCellValueEx(x, y, Color.BLACK, "");
        stars.forEach(e -> e.draw(this));
    }

    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            int x = this.getRandomNumber(HEIGHT);
            int y = this.getRandomNumber(HEIGHT);
            stars.add(new Star(x, y));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        enemyBullets.forEach(Bullet::move);
        playerBullets.forEach(Bullet::move);
        playerShip.move();
    }

    private void removeDeadBullets() {
        enemyBullets.removeIf(b -> b.y >= HEIGHT - 1 || !b.isAlive);
        playerBullets.removeIf(b -> b.y + b.height < 0 || !b.isAlive);
    }

    private void check() {
        playerShip.checkHit(enemyBullets);
        score += enemyFleet.checkHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) stopGameWithDelay();
        if (enemyFleet.getBottomBorder() >= playerShip.y) playerShip.kill();
        if (enemyFleet.getShipCount() < 1) {
            playerShip.win();
            stopGameWithDelay();
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        Color color = isWin ? Color.GREEN : Color.RED;
        String message = isWin ? "YOU WIN!!!" : "GAME OVER!!!";
        showMessageDialog(Color.BLACK, message, color, 64);
    }

    private void stopGameWithDelay() {
        if (++animationsCount >= 10) stopGame(playerShip.isAlive);
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) enemyBullets.add(bullet);
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
            return;
        }
        if (key == Key.LEFT) playerShip.setDirection(Direction.LEFT);
        else if (key == Key.RIGHT) playerShip.setDirection(Direction.RIGHT);
        else if (key == Key.SPACE) {
            Bullet bullet = playerShip.fire();
            if (bullet == null) return;
            if (playerBullets.size() < PLAYER_BULLETS_MAX) playerBullets.add(bullet);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && playerShip.getDirection() == Direction.LEFT ||
            key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT) playerShip.setDirection(Direction.UP);
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) return;
        super.setCellValueEx(x, y, cellColor, value);
    }
}
