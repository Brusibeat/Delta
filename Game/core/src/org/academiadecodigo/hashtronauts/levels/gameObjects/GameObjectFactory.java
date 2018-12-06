package org.academiadecodigo.hashtronauts.levels.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameObjectFactory {

    public static Platform createPlatform(Sprite sprite, float posX, float posY, int width, int height){
        return new Platform(sprite, posX, posY, width, height);
    }

    public static ExitPoint createExitPoint(Sprite sprite, float posX, float posY, int width, int height){
        return new ExitPoint(sprite, posX, posY, width, height);
    }
}
