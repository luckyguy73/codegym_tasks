package com.codegym.games.minesweeper;

import com.codegym.engine.cell.*;

import java.util.*;

public class MinesweeperGame extends Game {
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private static final String EMPTY = "";
    private static final int SIDE = 9;
    private static final Color ORIGINAL_COLOR = Color.DODGERBLUE;
    private static final Color OPEN_COLOR = Color.LIMEGREEN;
    private static final Color FLAG_COLOR = Color.NAVAJOWHITE;
    private static final Color MINE_COLOR = Color.RED;
    private static final Color DARK_COLOR = Color.BLACK;
    private final GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int countFlags;
    private int countMinesOnField;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; ++y)
            for (int x = 0; x < SIDE; ++x) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) countMinesOnField++;
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, ORIGINAL_COLOR);
                setCellValue(x, y, EMPTY);
            }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; ++y)
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; ++x) {
                if (y < 0 || y >= SIDE) continue;
                if (x < 0 || x >= SIDE) continue;
                if (gameField[y][x] == gameObject) continue;
                result.add(gameField[y][x]);
            }
        return result;
    }

    private void countMineNeighbors() {
        for (GameObject[] gameObjects : gameField)
            for (int x = 0; x < gameField[0].length; ++x)
                if (!gameObjects[x].isMine)
                    gameObjects[x].countMineNeighbors =
                            (int) getNeighbors(gameObjects[x]).stream().filter(f -> f.isMine).count();
    }

    private void openTile(int x, int y) {
        GameObject gf = gameField[y][x];
        if (isGameStopped || gf.isFlag || gf.isOpen) return;
        gf.isOpen = true;
        countClosedTiles--;
        if (gf.isMine) {
            setCellValueEx(x, y, MINE_COLOR, MINE);
            gameOver();
        } else {
            setCellNumber(x, y, gf.countMineNeighbors);
            score += 5;
            setScore(score);
            if (gf.countMineNeighbors == 0) {
                setCellValue(gf.x, gf.y, EMPTY);
                List<GameObject> neighbors = getNeighbors(gf);
                for (GameObject neighbor : neighbors) if (!neighbor.isOpen) openTile(neighbor.x, neighbor.y);
            }
            setCellColor(x, y, OPEN_COLOR);
            if (countClosedTiles == countMinesOnField) win();
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped) return;
        GameObject gf = gameField[y][x];
        if (!gf.isOpen && countFlags > 0 && !gf.isFlag) {
            countFlags--;
            gf.isFlag = true;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, FLAG_COLOR);
        } else if (gf.isFlag) {
            countFlags++;
            gf.isFlag = false;
            setCellValue(x, y, EMPTY);
            setCellColor(x, y, ORIGINAL_COLOR);
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(DARK_COLOR, "Game Over!!!", MINE_COLOR, 72);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(DARK_COLOR, "You Win!!!", ORIGINAL_COLOR, 72);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        score = 0;
        setScore(score);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        super.onMouseLeftClick(x, y);
        if (!isGameStopped) openTile(x, y);
        else restart();
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        super.onMouseRightClick(x, y);
        markTile(x, y);
    }
}
