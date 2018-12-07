package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform3;

public class DeltaGame extends Game {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level1;
    private PlatformLevel level2;
    private PlatformLevel level3;

    private PlatformPlayer[] character;

    private boolean position = false;
    private boolean finished1 = false;
    private boolean finished2 = false;
    private boolean finished3 = false;

    private int currentLevel;

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

        level3 = new Platform3();
        ((Platform3) level3).initLevelObjects();
        level3.levelInit();

        currentLevel = 1;

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

       /* switch (currentLevel) {
            case 1:
                renderLevel1();
                break;
            case 2:
                renderLevel2();
                break;
            case 3:
                renderLevel3();
                break;
        }*/

        if (finished2) {
            renderLevel3();
        } else if(finished1) {
            renderLevel2();
        }else{
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
                        position = false; // this needs to be false if you want to reset on next level
                        currentLevel++;
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
        for(PlatformPlayer character : character){
            if(!position){
                character.getRectangle().setY(Configurations.GROUND_LEVEL);
                character.getRectangle().setX(2);
            }
        }
        position = true;

        for (GameObject object : ((Platform2) level2).getGameObjects()) {
            batch.draw(object.getTexture(), object.getRectangle().x, object.getRectangle().y);

            //check if player landed (floor, or platform)
            for (PlatformPlayer character : character) {
                if (character.getRectangle().overlaps(object.getRectangle())) {
                    if (object instanceof ExitPoint) {
                        position = false; // this needs to be false if you want to reset on next level
                        currentLevel++;
                         finished2 = true;
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

    public void renderLevel3() {
        for(PlatformPlayer character : character){
            if(!position){
                character.getRectangle().setY(Configurations.GROUND_LEVEL);
                character.getRectangle().setX(2);
            }
        }
        position = true;

        for (GameObject object : ((Platform3) level3).getGameObjects()) {
            batch.draw(object.getTexture(), object.getRectangle().x, object.getRectangle().y);

            //check if player landed (floor, or platform)
            for (PlatformPlayer character : character) {

                if (character.getRectangle().overlaps(object.getRectangle())) {
                    if (object instanceof ExitPoint) {
                        position = false; // this needs to be false if you want to reset on next level
                        //currentLevel++;
                        finished3 = true;
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
}
