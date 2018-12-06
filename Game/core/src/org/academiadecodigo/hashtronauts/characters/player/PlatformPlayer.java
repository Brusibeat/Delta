package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlatformPlayer extends Player {

    private int x;
    private int y;


    public PlatformPlayer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void jump() {

    }

    private void move() {


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x += 200 * Gdx.graphics.getDeltaTime();

        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x -= 200 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {

        }

        if (x < 0) {
            x = 0;
        }
        if (x > 1820) {    // 1920-100
            x = 1820;
        }

        if (y < 0) {
            y = 0;
        }

        if (y > 930){
            y =
        }

    }

    private void useSkill() {

    }
}
