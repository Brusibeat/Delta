package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObjectFactory;

public class DeltaGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level;
    private PlatformPlayer player;

    private GameObject platform1;

    @Override
    public void create() {
        batch = new SpriteBatch();
        level = new PlatformLevel();
        level.levelInit();
        player = level.getPlatformPlayer();

        player.setFalling(false);

        platform1 = GameObjectFactory.createPlatform(new Texture("freddy.png"), 400, -30, 100, 40);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(player.getTexture(), player.getPosX(), player.getPosY());
        batch.draw(platform1.getTexture(), platform1.getPosX(), platform1.getPosY());

            if (player.isJumping()) {
                if (TimeUtils.nanoTime() - player.getLastJumpTime() < 250000000) {
                    player.setPosY((int) (player.getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
                }

                if (TimeUtils.nanoTime() - player.getLastJumpTime() > 300000000) {
                    player.stopJump();

                }
            } else {

                player.setPosY((int) (player.getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));
               // player.setFalling(true);

            }


        player.move();

            //if player is not jumping, player is allowed to jump
        if( !player.isFalling() ){
            player.jump();

        }

        //check if player landed (floor, or platform)
        if( player.getPosY() == 0 || player.getRectangle().overlaps(platform1.getRectangle())){

            player.setFalling(false);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
