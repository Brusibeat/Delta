package org.academiadecodigo.hashtronauts.levels.gameObjects;

import com.badlogic.gdx.graphics.Texture;

public class GameObjectFactory {

    public static Platform createPlatform(String texture, int posX, int posY, int width, int height){
        return new Platform(texture, posX, posY, width, height);
    }

    public static ExitPoint createExitPoint(String texture, int posX, int posY, int width, int height){
        return new ExitPoint(texture, posX, posY, width, height);
    }
}
