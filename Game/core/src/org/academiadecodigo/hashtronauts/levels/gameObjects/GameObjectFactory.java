package org.academiadecodigo.hashtronauts.levels.gameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameObjectFactory {

    public static Platform createPlatform(Texture texture, int posX, int posY, int width, int height) {
        return new Platform(texture, posX, posY, width, height);
    }

    public static ExitPoint createExitPoint(Texture texture, int posX, int posY, int width, int height) {
        return new ExitPoint(texture, posX, posY, width, height);
    }
}
