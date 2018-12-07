package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.gameObjects.ExitPoint;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.gameObjects.Platform;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform1;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform2;

public class DeltaGame extends Game {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level1;

    private PlatformPlayer[] character;

    private PlatformLevel level2;
    private boolean finished1 = false;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Configurations.WINDOW_WIDTH, Configurations.WINDOW_HEIGHT);

        level1 = new Platform1();

        ((Platform1) level1).initLevelObjects();
        level1.levelInit();

        character = new PlatformPlayer[4];

        character[0] = level1.getCharacter4();
        character[1] = level1.getCharacter3();
        character[2] = level1.getCharacter2();
        character[3] = level1.getPlayer();

        for (PlatformPlayer character : character) {
            character.setFalling(false);
        }

        level2 = new Platform2();
        ((Platform2) level2).initLevelObjects();
        level2.levelInit();

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        if (finished1) {
            renderLevel2();
        } else {
            renderLevel1();
        }

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }



    public void renderLevel1() {

        for (GameObject object : ((Platform1) level1).getGameObjects()) {
            batch.draw(object.getTexture(), object.getRectangle().x, object.getRectangle().y);

            //check if player landed (floor, or platform)
            for (PlatformPlayer character : character) {
                if (character.getRectangle().overlaps(object.getRectangle())) {
                    if (object instanceof ExitPoint) {
                        finished1 = true;
                    }
                    character.getRectangle().y = object.getRectangle().y + object.getRectangle().height;
                    character.setFalling(false);
                }
            }

        }

        for (PlatformPlayer character : character) {
            batch.draw(character.getTexture(), character.getPosX(), character.getPosY());

            if (character.isJumping()) {
                if (TimeUtils.nanoTime() - character.getLastJumpTime() < 250000000) {
                    character.setPosY((int) (character.getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
                }

                if (TimeUtils.nanoTime() - character.getLastJumpTime() > 300000000) {
                    character.stopJump();

                }
            } else {

                character.setPosY((int) (character.getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));

            }

            character.move();

            //if player is not jumping, player is allowed to jump
            if (!character.isFalling()) {
                character.jump();
            }
        }
    }

    public void renderLevel2() {
        




        /*for (GameObject object1 : ((Platform2) level2).getGameObjects()) {
            batch.draw(object1.getTexture(), object1.getRectangle().x, object1.getRectangle().y);

            //check if player landed (floor, or platform)
            if (player.getRectangle().overlaps(object1.getRectangle())) {
                if (object1 instanceof ExitPoint) {

                    //TODO: Create here next lvl (battle lvl)
                    System.out.println("End");
                }
                player.getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
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
    }
}
