package org.academiadecodigo.hashtronauts.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.Configurations;
import org.academiadecodigo.hashtronauts.DeltaGame;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform1;

public class Level1 extends AbstractScreen {

    private OrthographicCamera camera;

    private PlatformLevel level;
    private PlatformPlayer player;

    public Level1(final DeltaGame game){
        super(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Configurations.WINDOW_WIDTH, Configurations.WINDOW_HEIGHT);

        game.batch.setProjectionMatrix(camera.combined);

        level = new Platform1();

        ((Platform1) level).initLevelObjects();
        level.levelInit();

        player = level.getPlayer();

        player.setFalling(false);

    }
    
    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(float delta){
        super.render(delta);
        stage.draw();

        for (GameObject object : ((Platform1) level).getGameObjects()) {
            game.batch.draw(object.getTexture(), object.getRectangle().x, object.getRectangle().y);

            //check if player landed (floor, or platform)
            if (player.getRectangle().overlaps(object.getRectangle())){
                player.setPosY(object.getRectangle().y + object.getRectangle().height);
                player.setFalling(false);
            }
        }

        game.batch.draw(player.getTexture(), player.getPosX(), player.getPosY());

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
        }

        game.batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
