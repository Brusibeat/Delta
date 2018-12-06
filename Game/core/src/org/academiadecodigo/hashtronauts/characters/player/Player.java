package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.graphics.g2d.Sprite;
import org.academiadecodigo.hashtronauts.Configurations;

public abstract class Player {

    private Sprite[] playerSprites;
    private boolean[] availableCharacter;
    private int width = Configurations.PLAYER_WIDTH;
    private int height = Configurations.PLAYER_HEIGHT;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Sprite[] getPlayerSprites() {
        return playerSprites;
    }

    public void setPlayerSprites(Sprite[] playerSprites) {
        this.playerSprites = playerSprites;
    }

    public boolean[] getAvailableCharacter() {
        return availableCharacter;
    }

    public void setAvailableCharacter(boolean[] availableCharacter) {
        this.availableCharacter = availableCharacter;
    }
}
