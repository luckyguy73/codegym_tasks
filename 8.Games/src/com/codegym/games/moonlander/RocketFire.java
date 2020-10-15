package com.codegym.games.moonlander;

import com.codegym.engine.cell.*;

import java.util.List;

public class RocketFire extends GameObject {
    private List<int[][]> frames;
    private int frameIndex;
    private boolean isVisible;

    public RocketFire(List<int[][]> frameList) {
        super(0, 0, frameList.get(0));
        this.frames = frameList;
        this.frameIndex = 0;
        this.isVisible = false;
    }

    private void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size()) frameIndex = 0;
        matrix = frames.get(frameIndex);
    }

    public void show() {
        isVisible = true;
    }

    public void hide() {
        isVisible = false;
    }

    @Override
    public void draw(Game game) {
        if (!isVisible) return;
        nextFrame();
        super.draw(game);
    }
}

