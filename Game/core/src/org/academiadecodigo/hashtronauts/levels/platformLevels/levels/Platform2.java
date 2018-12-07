package org.academiadecodigo.hashtronauts.levels.platformLevels.levels;

import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;

import java.util.ArrayList;

public class Platform2 extends PlatformLevel {

    private ArrayList<GameObject> gameObjects;

    public void initLevelObjects(){
        gameObjects = new ArrayList<GameObject>();

        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 50, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 150, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 250, 250, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 100, 300, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 430, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 530, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 630, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 750, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 850, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 950, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 350, 900, 100, 20));

        gameObjects.add(GameObjectFactory.createPlatform(null, 450, 750, 100, 20));

        gameObjects.add(GameObjectFactory.createPlatform(null, 650, 800, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 850, 600, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1050, 400, 20,20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1200, 500, 20, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1400, 300, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1550, 400, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1650, 500, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1750, 600, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1650, 700, 10, 20));


        gameObjects.add(GameObjectFactory.createExitPoint("freddy.png", 1750, 850, 100,20 ));


    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
