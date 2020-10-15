package com.codegym.games.racer;

import com.codegym.engine.cell.*;
import com.codegym.games.racer.road.RoadManager;

public class RacerGame extends Game {
    private static final int RACE_GOAL_CARS_COUNT = 40;
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private FinishLine finishLine;
    private PlayerCar player;
    private ProgressBar progressBar;
    private RoadManager roadManager;
    private RoadMarking roadMarking;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        drawScene();
        setTurnTimer(40);
        isGameStopped = false;
        score = 3500;
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; ++x) {
            for (int y = 0; y < HEIGHT; ++y) {
                if (x == CENTER_X) setCellColor(CENTER_X, y, Color.WHITE);
                else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) setCellColor(x, y, Color.DIMGRAY);
                else setCellColor(x, y, Color.GREEN);
            }
        }
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        player.move();
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.RED, 64);
        stopTurnTimer();
        player.stop();
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU WIN!!!", Color.WHITE, 64);
        stopTurnTimer();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) super.setCellColor(x, y, color);
    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrash(player)) {
            gameOver();
            drawScene();
            return;
        }
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) finishLine.show();
        if (finishLine.isCrossed(player)) {
            win();
            drawScene();
            return;
        }
        moveAll();
        roadManager.generateNewRoadObjects(this);
        score -= 5;
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.RIGHT) player.setDirection(Direction.RIGHT);
        else if (key == Key.LEFT) player.setDirection(Direction.LEFT);
        else if (key == Key.SPACE && isGameStopped) createGame();
        else if (key == Key.UP) player.speed = 2;
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT) player.setDirection(Direction.NONE);
        else if (key == Key.LEFT && player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);
        else if (key == Key.UP) player.speed = 1;
    }
}

