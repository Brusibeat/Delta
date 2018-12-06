package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform1;

public class DeltaGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level;
    private PlatformPlayer player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Configurations.WINDOW_WIDTH, Configurations.WINDOW_HEIGHT);

        level = new Platform1();

        ((Platform1) level).initLevelObjects();
        level.levelInit();

        player = level.getPlayer();

        player.setFalling(false);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        for (GameObject object : ((Platform1) level).getGameObjects()) {
            batch.draw(object.getTexture(), object.getRectangle().x, object.getRectangle().y);

            //check if player landed (floor, or platform)
            if (player.getPosY() == 0 || player.getRectangle().overlaps(object.getRectangle())) {
                player.setFalling(false);
            }
        }

        batch.draw(player.getTexture(), player.getPosX(), player.getPosY());

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
        if (!player.isFalling()) {
            player.jump();
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
