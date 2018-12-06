package org.academiadecodigo.hashtronauts.levels.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public abstract class GameObject {

    private Texture texture;
    private Rectangle rectangle;

    public GameObject(String texture, int posX, int posY, int width, int height){
        if(texture == null) {
            this.texture = createTexture(posX, posY, width, height);
        }else{
            this.texture = new Texture(texture);
        }

        rectangle = new Rectangle();
        rectangle.x = posX;
        rectangle.y = posY;
        rectangle.width = width;
        rectangle.height = height;

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    //PARA TESTES
    private Texture createTexture(int posX, int posY, int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLUE);
        pixmap.fill();
        return new Texture(pixmap);
    }
}
