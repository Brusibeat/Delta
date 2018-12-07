package org.academiadecodigo.hashtronauts.levels.platformLevels.levels;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.hashtronauts.Configurations;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;

import java.util.ArrayList;

public class Platform2 extends PlatformLevel {

    private Texture bg;
    private ArrayList<GameObject> gameObjects;

    public Platform2(){
        bg = new Texture("bg_temple.jpg");
    }

    public void initLevelObjects(){
        gameObjects = new ArrayList<GameObject>();

        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 50+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 150+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 250, 250+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 100, 300+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 430+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 530+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 630+ Configurations.GROUND_LEVEL,100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 750+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 50, 850+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 150, 950+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 350, 900+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 450, 750+ Configurations.GROUND_LEVEL, 100, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 650, 800+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 850, 600+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1050, 400+ Configurations.GROUND_LEVEL, 20,20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1150, 500+ Configurations.GROUND_LEVEL, 20, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1400, 300+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1500, 400+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1600, 500+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1700, 600+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1650, 700+ Configurations.GROUND_LEVEL, 10, 20));
        gameObjects.add(GameObjectFactory.createPlatform(null, 1700, 800+ Configurations.GROUND_LEVEL, 10, 20));


        gameObjects.add(GameObjectFactory.createExitPoint("freddy.png", 1750, 850+ Configurations.GROUND_LEVEL, 100,20 ));


    }

    public ArrayList<GameObject> getGameObjects(){
        return gameObjects;
    }

    public Texture getBg() {
        return bg;
    }
}
