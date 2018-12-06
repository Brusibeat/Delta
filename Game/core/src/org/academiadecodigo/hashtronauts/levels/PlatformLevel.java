package org.academiadecodigo.hashtronauts.levels;

import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;

public class PlatformLevel extends Level {
    private PlatformPlayer platformPlayer;

    public PlatformPlayer getPlatformPlayer() {
        return platformPlayer;
    }

    public void setPlatformPlayer(PlatformPlayer platformPlayer) {
        this.platformPlayer = platformPlayer;
    }
}
