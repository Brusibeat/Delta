package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.gameObjects.ExitPoint;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform1;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform2;

import java.util.ArrayList;

public class DeltaGame extends Game {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level1;

    private ArrayList<PlatformPlayer> characters;

    private PlatformLevel level2;
    private boolean finished1 = false;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Configurations.WINDOW_WIDTH, Configurations.WINDOW_HEIGHT);

        level1 = new Platform1();

        Texture bg = new Texture("bg_temple.jpg");

        level1.setBg(bg);

        ((Platform1) level1).initLevelObjects();
        level1.levelInit();

        characters = new ArrayList<PlatformPlayer>();

        characters.add(level1.getCharacter4());
        characters.add(level1.getCharacter3());
        characters.add(level1.getCharacter2());
        characters.add(level1.getPlayer());

        for (PlatformPlayer character : characters) {
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

        batch.draw(level1.getBg(), 0, 0);

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
            for (PlatformPlayer character : characters) {
                if (character.getRectangle().overlaps(object.getRectangle())) {
                    if (object instanceof ExitPoint) {
                        finished1 = true;
                    }
                    character.getRectangle().y = object.getRectangle().y + object.getRectangle().height;
                    character.setFalling(false);
                }
            }

        }

        for (PlatformPlayer character : characters) {
            batch.draw(character.getTexture(), character.getPosX(), character.getPosY());

            if (character.isJumping()) {
                if (TimeUtils.nanoTime() - character.getLastJumpTime() < 250000000) {
                    character.setPosY((int) (character.getPosY() + ((Configurations.PLAYER_JUMP - character.getDelay() * 20) * Gdx.graphics.getDeltaTime())));
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

        for (GameObject object1 : ((Platform2) level2).getGameObjects()) {
            batch.draw(object1.getTexture(), object1.getRectangle().x, object1.getRectangle().y);

            for (PlatformPlayer character : characters) {
                //check if player landed (floor, or platform)
                if (character.getRectangle().overlaps(object1.getRectangle())) {
                    if (object1 instanceof ExitPoint) {
                        //TODO: Create here next lvl (battle lvl)
                    }
                    character.getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
                    character.setFalling(false);
                }
            }

        }
        for (PlatformPlayer character : characters) {
            character.goToInitial();

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
}
