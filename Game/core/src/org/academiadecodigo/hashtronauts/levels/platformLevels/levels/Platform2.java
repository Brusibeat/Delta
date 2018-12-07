package org.academiadecodigo.hashtronauts.levels.platformLevels.levels;

import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;

import java.util.ArrayList;

public class Platform2 extends PlatformLevel {

    private ArrayList<GameObject> gameObjects;

    public void initLevelObjects(){
        gameObjects = new ArrayList<GameObject>();

       // gameObjects.add(GameObjectFactory.createPlatform(null, 50, 50, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 150, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 250, 250, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 100, 300, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 430, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 530, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 400, 500, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 500, 350, 100, 20));
     /*   gameObjects.add(GameObjectFactory.createPlatform(null, 700, 350, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 800, 450, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 700, 550, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 600, 670, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 800, 730, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1000, 730, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1200, 530, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1350, 630, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1450, 730, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1550, 850, 100, 20));*/

        gameObjects.add(GameObjectFactory.createExitPoint("freddy.png", 1750, 850, 100,20 ));


    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
