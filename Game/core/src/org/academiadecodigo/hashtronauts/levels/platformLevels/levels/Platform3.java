package org.academiadecodigo.hashtronauts.levels.platformLevels.levels;

import org.academiadecodigo.hashtronauts.Configurations;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;

import java.util.ArrayList;

public class Platform3 extends PlatformLevel {

    private ArrayList<GameObject> gameObjects;

    public void initLevelObjects(){
        gameObjects = new ArrayList<GameObject>();

        gameObjects.add(GameObjectFactory.createPlatform(null, 500, 50+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 400, 150+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 300, 250+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 350+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 300, 400+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 400, 500+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 300, 450+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 400, 550+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 500, 550+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 650, 350+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 750, 450+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 850, 550+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 950, 650+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1050, 750+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1150, 850+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1450, 250+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1550, 250+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1650, 250+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1750, 300+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1750, 400+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1650, 500+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1550, 600+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1450, 700+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1550, 800+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1650, 800+ Configurations.GROUND_LEVEL, 5, 10));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1750, 800+ Configurations.GROUND_LEVEL, 5, 10));



        gameObjects.add(GameObjectFactory.createExitPoint("freddy.png", 1750, 850+ Configurations.GROUND_LEVEL, 100,20 ));


    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
