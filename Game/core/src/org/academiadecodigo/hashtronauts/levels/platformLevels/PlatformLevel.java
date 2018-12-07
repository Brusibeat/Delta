package org.academiadecodigo.hashtronauts.levels.platformLevels;

import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;

public abstract class PlatformLevel implements Platform {

    private PlatformPlayer player;
    private PlatformPlayer character2;
    private PlatformPlayer character3;
    private PlatformPlayer character4;

    public void levelInit(){
        player = new PlatformPlayer();
        character2 = new PlatformPlayer();
        character3 = new PlatformPlayer();
        character4 = new PlatformPlayer();

        player.initPlayer(0);
        character2.initPlayer(1);
        character3.initPlayer(2);
        character4.initPlayer(3);
    }

    public PlatformPlayer getPlayer() {
        return player;
    }

    public PlatformPlayer getCharacter2() {
        return character2;
    }

    public PlatformPlayer getCharacter3() {
        return character3;
    }

    public PlatformPlayer getCharacter4() {
        return character4;
    }
}
