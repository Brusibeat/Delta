package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlatformPlayer extends Player {

    private int x;
    private int y;
    private boolean isJumping = false;


    public PlatformPlayer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void jump() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {



            y += 200 * Gdx.graphics.getDeltaTime();

        }
    }

    public void move() {


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x += 200 * Gdx.graphics.getDeltaTime();

        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x -= 200 * Gdx.graphics.getDeltaTime();
        }

        if (x < 0) {
            x = 0;
        }
        //Window widht 1920
        if (x > 1820) {    // 1920-100
            x = 1820;
        }

        if (y < 0) {
            y = 0;
        }
        //Window height 1920
        if (y > 930) {   // 1080 - 150
            y = 930;
        }

    }

    private void useSkill() {

    }
}
