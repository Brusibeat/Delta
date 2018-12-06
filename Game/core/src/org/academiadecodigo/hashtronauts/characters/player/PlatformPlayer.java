package org.academiadecodigo.hashtronauts.characters.player;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class PlatformPlayer extends Player {

    private Texture texture;
    private Rectangle rectangle;

    public Rectangle getRectangle() {
        return rectangle;
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

    private void jump(){

    }

    private void move(){

    }

    private void useSkill(){

    }
}
