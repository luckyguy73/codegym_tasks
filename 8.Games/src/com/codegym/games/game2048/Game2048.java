package com.codegym.games.game2048;

import com.codegym.engine.cell.*;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private boolean isGameStopped = false;
    private int[][] gameField;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int row = 0; row < SIDE; ++row)
            for (int col = 0; col < SIDE; ++col)
                setCellColoredNumber(col, row, gameField[row][col]);
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
            return;
        }

        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[x][y] != 0);

        gameField[x][y] = getRandomNumber(10) == 9 ? 4 : 2;
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 2: return Color.LIGHTBLUE;
            case 4: return Color.LIGHTGREEN;
            case 8: return Color.LIGHTPINK;
            case 16: return Color.LIGHTYELLOW;
            case 32: return Color.LIGHTCYAN;
            case 64: return Color.LIGHTCORAL;
            case 128: return Color.LIGHTSKYBLUE;
            case 256: return Color.LIGHTSEAGREEN;
            case 512: return Color.LIGHTSALMON;
            case 1024: return Color.LIGHTSTEELBLUE;
            case 2048: return Color.ORANGE;
            default: return Color.NAVAJOWHITE;
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        String s = value == 0 ? "" : Integer.toString(value);
        setCellValueEx(x, y, getColorByValue(value), s);
    }

    private boolean compressRow(int[] row) {
        int i = 0, j = -1, n = row.length;
        int[] copy = Arrays.copyOf(row, n);
        while (++j < n) if (row[j] != 0) row[i++] = row[j];
        while (i < n) row[i++] = 0;
        return !Arrays.equals(row, copy);
    }

    private boolean mergeRow(int[] row) {
        int n = row.length;
        int[] copy = Arrays.copyOf(row, n);
        for (int i = 0; i < n - 1; ++i)
            if (row[i] == row[i + 1]) {
                row[i] *= 2;
                row[i + 1] = 0;
                score += row[i];
                setScore(score);
            }
        return !Arrays.equals(row, copy);
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) restart();
            return;
        }

        if (!canUserMove()) {
            gameOver();
            return;
        }

        switch (key) {
            case LEFT: moveLeft(); break;
            case RIGHT: moveRight(); break;
            case UP: moveUp();  break;
            case DOWN: moveDown(); break;
            default: return;
        }

        drawScene();
    }

    private void restart() {
        isGameStopped = false;
        createGame();
        drawScene();
    }

    private void moveLeft() {
        boolean changed = false;
        for (int[] row : gameField) {
            if (compressRow(row)) changed = true;
            if (mergeRow(row)) changed = true;
            if (compressRow(row)) changed = true;
        }
        if (changed) createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        for (int r = 0; r < SIDE / 2; ++r)
            for (int c = r; c < SIDE - r - 1; ++c) {
                int t = gameField[r][c];
                gameField[r][c] = gameField[SIDE - 1 - c][r];
                gameField[SIDE - 1 - c][r] = gameField[SIDE - 1 - r][SIDE - 1 - c];
                gameField[SIDE - 1 - r][SIDE - 1 - c] = gameField[c][SIDE - 1 - r];
                gameField[c][SIDE - 1 - r] = t;
            }
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU WIN!!", Color.WHITE, 72);
    }

    private int getMaxTileValue() {
        return getStats().getMax();
    }

    private IntSummaryStatistics getStats() {
        return Arrays.stream(gameField).flatMapToInt(Arrays::stream).summaryStatistics();
    }

    private boolean canUserMove() {
        return getStats().getMin() == 0 || checkMerge();
    }

    private boolean checkMerge() {
        for (int r = 0; r < SIDE; ++r)
            for (int c = 0; c < SIDE; ++c)
                if (checkNeighbors(r, c)) return true;
        return false;
    }

    private boolean checkNeighbors(int r, int c) {
        int[] d = {0, 1, 0, -1, 0};
        for (int k = 0; k < d.length - 1; ++k) {
            int x = r + d[k], y = c + d[k + 1], val = gameField[r][c];
            if (x >= 0 && x < SIDE && y >= 0 && y < SIDE && gameField[x][y] == val) return true;
        }
        return false;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "YOU LOSE!!", Color.RED, 72);
    }
}
