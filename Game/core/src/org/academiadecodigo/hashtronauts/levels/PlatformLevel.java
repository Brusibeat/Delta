package org.academiadecodigo.hashtronauts.levels;

import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class PlatformLevel extends Level {

    private PlatformPlayer platformPlayer;

    public void levelInit(){

        Texture characterTexture = new Texture("freddy.png");
        Rectangle rectangle = new Rectangle();
        platformPlayer = new PlatformPlayer();

        platformPlayer.setRectangle(rectangle);
        platformPlayer.setTexture(characterTexture);
        platformPlayer.setPosX(0);
        platformPlayer.setPosY(0);
    }

    public PlatformPlayer getPlatformPlayer() {
        return platformPlayer;
    }

}
