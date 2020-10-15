package com.codegym.games.moonlander;

import com.codegym.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private GameObject landscape, platform;
    private Rocket rocket;
    private boolean isUpPressed, isLeftPressed, isRightPressed, isGameStopped;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void createGame() {
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isUpPressed = isLeftPressed = isRightPressed = isGameStopped = false;
        score = 1000;
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; ++i) for (int j = 0; j < HEIGHT; ++j) setCellColor(i, j, Color.BLACK);
        rocket.draw(this);
        landscape.draw(this);
    }

    private void createGameObjects() {
        rocket = new Rocket((WIDTH / 2.) - 4, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, HEIGHT - 1, ShapeMatrix.PLATFORM);
    }

    private void check() {
        if (rocket.isCollision(platform) && rocket.isStopped()) win();
        else if (rocket.isCollision(landscape)) gameOver();
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "You Win!!!", Color.WHITE, 64);
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "You Crashed!!!", Color.RED, 64);
        stopTurnTimer();
        score = 0;
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        check();
        drawScene();
        if (score > 0) score--;
        setScore(score);
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            isLeftPressed = true;
            isRightPressed = false;
        } else if (key == Key.RIGHT) {
            isRightPressed = true;
            isLeftPressed = false;
        } else if (key == Key.UP) isUpPressed = true;
        else if (key == Key.SPACE && isGameStopped) createGame();
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) isUpPressed = false;
        else if (key == Key.LEFT) isLeftPressed = false;
        else if (key == Key.RIGHT) isRightPressed = false;
    }
}

