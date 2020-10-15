package com.codegym.games.snake;

import com.codegym.engine.cell.*;
import com.codegym.engine.cell.Color;

import java.util.*;

public class Snake {

    private final List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private Direction direction = Direction.LEFT;

    public boolean isAlive = true;

    public Snake(int x, int y) {
        GameObject first = new GameObject(x, y);
        GameObject second = new GameObject(x + 1, y);
        GameObject third = new GameObject(x + 2, y);

        snakeParts.add(first);
        snakeParts.add(second);
        snakeParts.add(third);
    }

    public void draw(Game game) {
        Color snakeColor = isAlive ? Color.DARKGREEN : Color.RED;
        boolean first = true;
        for (GameObject obj : snakeParts) {
            if (!first) game.setCellValueEx(obj.x, obj.y, Color.NONE, BODY_SIGN, snakeColor, 75);
            else {
                game.setCellValueEx(obj.x, obj.y, Color.NONE, HEAD_SIGN, snakeColor, 75);
                first = false;
            }
        }
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0), obj;
        switch (direction) {
            case UP: obj = new GameObject(head.x, head.y - 1); break;
            case DOWN: obj = new GameObject(head.x, head.y + 1); break;
            case LEFT: obj = new GameObject(head.x - 1, head.y); break;
            case RIGHT: obj = new GameObject(head.x + 1, head.y); break;
            default: throw new IllegalStateException("Unexpected value: " + direction);
        }
        return obj;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public void move(Apple apple) {
        GameObject head = createNewHead();
        if (head.x < 0 || head.x >= SnakeGame.WIDTH || head.y < 0 || head.y >= SnakeGame.HEIGHT || checkCollision(head))
            this.isAlive = false;
        if (this.isAlive) {
            snakeParts.add(0, head);
            if (head.x == apple.x && head.y == apple.y) apple.isAlive = false;
            else removeTail();
        }
    }

    public boolean checkCollision(GameObject obj) {
        for (GameObject segment : snakeParts) if (obj.x == segment.x && obj.y == segment.y) return true;
        return false;
    }

    public void setDirection(Direction new_direction) {
        if (this.direction == Direction.LEFT && new_direction != Direction.RIGHT)
            if (snakeParts.get(0).x != snakeParts.get(1).x)
                this.direction = new_direction;
        if (this.direction == Direction .RIGHT && new_direction != Direction.LEFT)
            if (snakeParts.get(0).x != snakeParts.get(1).x)
                this.direction = new_direction;
        if (this.direction == Direction.UP && new_direction != Direction.DOWN)
            if (snakeParts.get(0).y != snakeParts.get(1).y)
                this.direction = new_direction;
        if (this.direction == Direction.DOWN && new_direction != Direction.UP)
            if (snakeParts.get(0).y != snakeParts.get(1).y)
                this.direction = new_direction;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
