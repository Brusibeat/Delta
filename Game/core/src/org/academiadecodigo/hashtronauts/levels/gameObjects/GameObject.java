package org.academiadecodigo.hashtronauts.levels.gameObjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    private Texture texture;
    private Rectangle rectangle;

    public GameObject(String texture, float posX, float posY, int width, int height){
        if(texture == null) {
            this.texture = createTexture(width, height);
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
    private Texture createTexture(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLUE);
        pixmap.fill();
        return new Texture(pixmap);
    }
}
