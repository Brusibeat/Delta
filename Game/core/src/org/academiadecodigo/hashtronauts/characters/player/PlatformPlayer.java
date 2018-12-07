package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.Configurations;

public class PlatformPlayer extends Player {

    private Texture texture;
    private Rectangle rectangle;
    private boolean isJumping = false;
    private boolean isFalling = false;
    private long lastJumpTime;
    private int delay;

    public void initPlayer(int delay) {
        //texture = new Texture("freddy.png");
        this.delay = delay;
        rectangle = new Rectangle();
        rectangle.x = 40 - delay * 10;
        rectangle.y = 0;
        rectangle.width = Configurations.PLAYER_WIDTH;
        rectangle.height = 1;
        texture = createTexture(Configurations.PLAYER_WIDTH, Configurations.PLAYER_HEIGHT);
    }

    public int getDelay() {
        return delay;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public long getLastJumpTime() {
        return lastJumpTime;
    }

    public void stopJump() {
        isJumping = false;
        isFalling = true;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getPosX() {
        return rectangle.x;
    }

    public void setPosX(int posX) {
        rectangle.x = posX;
    }

    public float getPosY() {
        return rectangle.y;
    }

    public void setPosY(int posY) {
        rectangle.y = posY;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

    public void jump() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !isJumping) {
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
            isFalling = false;
        }

        if (rectangle.y > Configurations.WINDOW_HEIGHT - Configurations.PLAYER_HEIGHT) {
            rectangle.y = Configurations.WINDOW_HEIGHT - Configurations.PLAYER_HEIGHT;
        }

    }

    private Texture createTexture(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        if (delay == 0) {
            pixmap.setColor(Color.RED);
        }
        if (delay == 1) {
            pixmap.setColor(Color.BLACK);
        }
        if (delay == 2) {
            pixmap.setColor(Color.GRAY);
        }
        if (delay == 3) {
            pixmap.setColor(Color.LIGHT_GRAY);
        }

        pixmap.fill();
        return new Texture(pixmap);
    }

    private void useSkill() {

    }


}