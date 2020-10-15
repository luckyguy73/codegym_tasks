package com.codegym.games.racer.road;

import com.codegym.engine.cell.Game;
import com.codegym.games.racer.*;

import java.util.*;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private static final int PLAYER_CAR_DISTANCE = 12;
    private List<RoadObject> items = new ArrayList<>();
    private int passedCarsCount = 0;


    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.SPIKE) return new Spike(x, y);
        if (type == RoadObjectType.DRUNK_CAR) return new MovingCar(x, y);
        return new Car(type, x, y);
    }

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject obj = createRoadObject(type, x, y);
        if (isRoadSpaceFree(obj)) items.add(obj);
    }

    public void draw(Game game) {
        for (RoadObject item : items) item.draw(game);
    }

    public void move(int boost) {
        for (RoadObject item : items) item.move(boost + item.speed, items);
        deletePassedItems();
    }

    private boolean spikeExists() {
        return items.stream().anyMatch(f -> f.type == RoadObjectType.SPIKE);
    }

    private boolean movingCarExists() {
        return items.stream().anyMatch(f -> f.type == RoadObjectType.DRUNK_CAR);
    }

    private void generateSpike(Game game) {
        int rand = game.getRandomNumber(100);
        if (rand < 10 && !spikeExists()) addRoadObject(RoadObjectType.SPIKE, game);
    }

    private void generateRegularCar(Game game) {
        int rand = game.getRandomNumber(100);
        int carTypeNumber = game.getRandomNumber(4);
        if (rand < 30) addRoadObject(RoadObjectType.values()[carTypeNumber], game);
    }

    private void generateMovingCar(Game game) {
        int rand = game.getRandomNumber(100);
        if (rand < 10 && !movingCarExists()) addRoadObject(RoadObjectType.DRUNK_CAR, game);
    }

    public void generateNewRoadObjects(Game game) {
        generateSpike(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    private void deletePassedItems() {
        Iterator<RoadObject> iterator = items.iterator();
        while (iterator.hasNext()) {
            RoadObject item = iterator.next();
            if (item.y >= RacerGame.HEIGHT) {
                iterator.remove();
                if (item.type != RoadObjectType.SPIKE) passedCarsCount++;
            }
        }
    }

    public boolean checkCrash(PlayerCar player) {
        for (RoadObject item : items) if (item.isCollision(player)) return true;
        return  false;
    }

    private boolean isRoadSpaceFree(RoadObject obj) {
        for (RoadObject item : items) if (item.isCollisionWithDistance(obj, PLAYER_CAR_DISTANCE)) return false;
        return true;
    }

    public int getPassedCarsCount() {
        return passedCarsCount;
    }
}

