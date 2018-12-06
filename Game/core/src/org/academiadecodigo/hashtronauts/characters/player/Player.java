package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Player {

    private Sprite[] playerSprites;
    private boolean[] availableCharacter;

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
