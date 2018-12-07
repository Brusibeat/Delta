package org.academiadecodigo.hashtronauts.levels.platformLevels;

import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;

public abstract class PlatformLevel implements Platform {

    private PlatformPlayer player;

    public void levelInit(){
        player = new PlatformPlayer();
        player.initPlayer();
    }

    public PlatformPlayer getPlayer() {
        return player;
    }

}
