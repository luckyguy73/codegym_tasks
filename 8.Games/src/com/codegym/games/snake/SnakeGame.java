package com.codegym.games.snake;

import com.codegym.engine.cell.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private static final int GOAL = 28;
    private boolean isGameStopped;
    private int score;
    private int turnDelay;
    private Apple apple;
    private Snake snake;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        this.snake.move(apple);
        if (!this.apple.isAlive) {
            createNewApple();
            this.score += 5;
            setScore(this.score);
            this.turnDelay -= 10;
            setTurnTimer(this.turnDelay);
        }
        if (!this.snake.isAlive) gameOver();
        if (this.snake.getLength() > GOAL) win();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT: this.snake.setDirection(Direction.LEFT); break;
            case RIGHT: this.snake.setDirection(Direction.RIGHT); break;
            case UP: this.snake.setDirection(Direction.UP); break;
            case DOWN: this.snake.setDirection(Direction.DOWN); break;
            case SPACE: if (isGameStopped) createGame(); break;
        }
    }

    private void createGame() {
        this.score = 0;
        setScore(this.score);
        this.snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        this.isGameStopped = false;
        drawScene();
        this.turnDelay = 300;
        setTurnTimer(this.turnDelay);
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; ++x)
            for (int y = 0; y < HEIGHT; ++y)
                setCellValueEx(x, y, Color.LIGHTSALMON, "");

        this.snake.draw(this);
        this.apple.draw(this);
    }

    private void createNewApple() {
        Apple potential_apple;
        do {
            int apple_x = getRandomNumber(WIDTH);
            int apple_y = getRandomNumber(HEIGHT);
            potential_apple = new Apple(apple_x, apple_y);
        } while (this.snake.checkCollision(potential_apple));
        this.apple = potential_apple;
    }

    private void gameOver() {
        stopTurnTimer();
        this.isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.WHITE, 72);
    }

    private void win() {
        stopTurnTimer();
        this.isGameStopped = true;
        showMessageDialog(Color.BLACK, "You Win!!", Color.WHITE, 72);
    }

}
