package org.academiadecodigo.hashtronauts.levels.gameObjects;

public class GameObjectFactory {

    public static Platform createPlatform(String texture, float posX, float posY, int width, int height) {
        return new Platform(texture, posX, posY, width, height);
    }

    public static ExitPoint createExitPoint(String texture, float posX, float posY, int width, int height) {
        return new ExitPoint(texture, posX, posY, width, height);
    }
}
