package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
<<<<<<< HEAD
import com.badlogic.gdx.graphics.Texture;
=======
import com.badlogic.gdx.utils.TimeUtils;
>>>>>>> bdd3b52ca78bd1846930f1f1bff3047fa2a3c5b7
import org.academiadecodigo.hashtronauts.Configurations;

import java.awt.*;

public class PlatformPlayer extends Player {

    private Texture texture;
    private Rectangle rectangle;
    private boolean isJumping = false;
    private long lastJumpTime;

    public Rectangle getRectangle() {
        return rectangle;
    }

    public long getLastJumpTime() {
        return lastJumpTime;
    }

    public void stopJump(){
        isJumping = false;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getPosX() {
        return rectangle.x;
    }

    public void setPosX(int posX) {
        rectangle.x = posX;
    }

    public int getPosY() {
        return rectangle.y;
    }

    public void setPosY(int posY) {
        rectangle.y = posY;
    }

<<<<<<< HEAD
    public void jump() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

            if (isJumping){
                rectangle.y += Configurations.PLAYER_FLOW * Gdx.graphics.getDeltaTime();

            }


            //rectangle.y -= Configurations.PLAYER_FLOW * Gdx.graphics.getDeltaTime();
=======
    public boolean isJumping(){
        return isJumping;
    }
>>>>>>> bdd3b52ca78bd1846930f1f1bff3047fa2a3c5b7

    public void jump() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            isJumping = true;
            lastJumpTime = TimeUtils.nanoTime();
        }
    }

    public void move() {


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rectangle.x -= Configurations.PLAYER_FLOW * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rectangle.x += Configurations.PLAYER_FLOW * Gdx.graphics.getDeltaTime();
        }

        if (rectangle.x < 0) {
            rectangle.x = 0;
        }

        if (rectangle.x > Configurations.WINDOW_WIDTH - Configurations.PLAYER_WIDTH) {
            rectangle.x = Configurations.WINDOW_WIDTH - Configurations.PLAYER_WIDTH;
        }

        if (rectangle.y < 0) {
            rectangle.y = 0;
        }

        if (rectangle.y > Configurations.WINDOW_HEIGHT - Configurations.PLAYER_HEIGHT) {
            rectangle.y = Configurations.WINDOW_HEIGHT - Configurations.PLAYER_HEIGHT;
        }

    }

    private void useSkill() {

    }
}
