package org.academiadecodigo.hashtronauts.levels.platformLevels;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;

public abstract class PlatformLevel implements Platform {

    private PlatformPlayer player;
    private PlatformPlayer character2;
    private PlatformPlayer character3;
    private PlatformPlayer character4;

    private Texture char1;
    private Texture char2;
    private Texture char3;
    private Texture char4;

    public void levelInit(){

        char1 = new Texture("1.png");
        char2 = new Texture("2.png");
        char3 = new Texture("3.png");
        char4 = new Texture("4.png");

        player = new PlatformPlayer();
        character2 = new PlatformPlayer();
        character3 = new PlatformPlayer();
        character4 = new PlatformPlayer();

        player.setTexture(char1);
        character2.setTexture(char2);
        character3.setTexture(char3);
        character4.setTexture(char4);

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
