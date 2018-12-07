package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform1;
import org.academiadecodigo.hashtronauts.screens.ScreenManager;

public class DeltaGame extends Game {
    public SpriteBatch batch;

    private ScreenManager screenManager;

    @Override
    public void create() {
        batch = new SpriteBatch();

        screenManager = new ScreenManager(this);

        /*level = new Level1();

        ((Level1) level).initLevelObjects();
        level.levelInit();

        player = level.getPlayer();

        player.setFalling(false);*/

    }

    @Override
    public void render() {
        super.render();

        batch.begin();

        /*for (GameObject object : ((Level1) level).getGameObjects()) {
            batch.draw(object.getTexture(), object.getRectangle().x, object.getRectangle().y);

            //check if player landed (floor, or platform)
            if (player.getRectangle().overlaps(object.getRectangle())){
                player.setPosY(object.getRectangle().y + object.getRectangle().height);
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

        }


        player.move();

        //if player is not jumping, player is allowed to jump
        if (!player.isFalling()) {
            player.jump();
        }*/

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        /*batch.dispose();
        player.getTexture().dispose();
        for (GameObject object : ((Level1) level).getGameObjects()){
            object.getTexture().dispose();
        }*/
    }
}
