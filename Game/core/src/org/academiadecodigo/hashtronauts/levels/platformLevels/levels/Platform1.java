package org.academiadecodigo.hashtronauts.levels.platformLevels.levels;

import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;

import java.util.ArrayList;

public class Platform1 extends PlatformLevel {

    private ArrayList<GameObject> gameObjects;

    public void initLevelObjects(){
        gameObjects = new ArrayList<GameObject>();

        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 50, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 250, 150, 100, 20));
    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }
}
