package org.academiadecodigo.hashtronauts.levels.platformLevels.levels;

import org.academiadecodigo.hashtronauts.Configurations;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;

import java.util.ArrayList;

public class Platform1 extends PlatformLevel {

    private ArrayList<GameObject> gameObjects;

    public void initLevelObjects(){
        gameObjects = new ArrayList<GameObject>();

        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 50 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 150 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 250, 250 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 100, 300 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 430 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 530 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 400, 500 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 500, 350 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 700, 350 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 800, 450 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 700, 550 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 600, 670 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 800, 730 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1000, 730 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1200, 530 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1350, 630 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1450, 730 + Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1550, 850 + Configurations.GROUND_LEVEL, 100, 20));

        gameObjects.add(GameObjectFactory.createExitPoint("freddy.png", 1750, 850 + Configurations.GROUND_LEVEL, 100,20 ));


/*
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 100, 100, 50));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 100, 100, 50));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 100, 100, 50));*/
    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
