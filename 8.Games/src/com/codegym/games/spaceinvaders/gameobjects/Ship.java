package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.engine.cell.Game;

import java.util.*;

public class Ship extends GameObject {
    private List<int[][]> frames;
    public boolean isAlive = true;
    private boolean loopAnimation = false;
    private int frameIndex;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
        super.setMatrix(viewFrame);
        frames = new ArrayList<>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size()) {
            if (!loopAnimation) return;
            frameIndex = 0;
        }
        matrix = frames.get(frameIndex);
    }

    public boolean isVisible() {
        return isAlive || frameIndex < frames.size();
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
        super.setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }
}
