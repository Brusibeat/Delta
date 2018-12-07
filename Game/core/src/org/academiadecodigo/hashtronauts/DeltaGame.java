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

        switch (currentLevel) {
            case 1:
                renderLevel1();
                break;
            case 2:
                renderLevel2();
                break;
            case 3:
                renderLevel3();
                break;
        }

        /*if (finished1) {
            renderLevel2();
        } else {
            renderLevel1();
        }

        if (finished2) {

            renderLevel3();
        }*/


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
                        currentLevel++;
                    }
                    character.getRectangle().y = object.getRectangle().y + object.getRectangle().height;
                    character.setFalling(false);
                }
            }

        }


        batch.draw(character[0].getTexture(), character[0].getPosX(), character[0].getPosY());

        if (character[0].isJumping()) {
            if (TimeUtils.nanoTime() - character[0].getLastJumpTime() < 250000000) {
                character[0].setPosY((int) (character[0].getPosY() + ((Configurations.PLAYER_JUMP - character[0].getDelay() * 10) * Gdx.graphics.getDeltaTime())));
            }

            if (TimeUtils.nanoTime() - character[0].getLastJumpTime() > 300000000) {
                character[0].stopJump();

            }
        } else {

            character[0].setPosY((int) (character[0].getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));

        }

        character[0].move();

        //if player is not jumping, player is allowed to jump
        if (!character[0].isFalling()) {
            character[0].jump();
        }


    }


    public void renderLevel2() {

        if (character[0].getRectangle().getX() == character[1].getRectangle().getX() &&
                character[0].getRectangle().getY() == character[1].getRectangle().getY()) {

            character[1].getRectangle().setX(character[0].getRectangle().getX());
        }

        if (!position) {
            character[0].getRectangle().setX(0);
            character[0].getRectangle().setY(0);
            character[1].getRectangle().setX(character[0].getRectangle().getX() - 40);
            character[1].getRectangle().setY(0);

            position = true;

        }

        for (GameObject object1 : ((Platform2) level2).getGameObjects()) {
            batch.draw(object1.getTexture(), object1.getRectangle().x, object1.getRectangle().y);

            //check if player landed (floor, or platform)
            if (character[0].getRectangle().overlaps(object1.getRectangle()) && character[1].getRectangle().overlaps(object1.getRectangle())) {
                if (object1 instanceof ExitPoint) {
                    position = false; // this needs to be false if you want to reset on next level
                    currentLevel++;
                    System.out.println("End");
                }
                character[0].getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
                character[1].getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
                character[0].setFalling(false);
                character[1].setFalling(false);

            }

        }

        batch.draw(character[0].getTexture(), character[0].getPosX(), character[0].getPosY());
        batch.draw(character[1].getTexture(), character[1].getPosX(), character[1].getPosY());

        if (character[0].isJumping() && character[1].isJumping()) {
            if ((TimeUtils.nanoTime() - character[0].getLastJumpTime() < 250000000) &&
                    (TimeUtils.nanoTime() - character[1].getLastJumpTime() < 250000000)) {
                character[0].setPosY((int) (character[0].getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
                character[1].setPosY((int) (character[1].getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
            }

            if ((TimeUtils.nanoTime() - character[0].getLastJumpTime() > 300000000) &&
                    (TimeUtils.nanoTime() - character[1].getLastJumpTime() > 300000000)) {
                character[0].stopJump();
                character[1].stopJump();


            }
        } else {

            character[0].setPosY((int) (character[0].getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));
            character[1].setPosY((int) (character[1].getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));

        }

        character[0].move();
        character[1].move();


        //if player is not jumping, player is allowed to jump
        if (!character[0].isFalling() && !character[1].isFalling()) {
            character[0].jump();
            character[1].jump();
        }
    }

    public void renderLevel3() {

        if (character[0].getRectangle().getX() == character[1].getRectangle().getX() &&
                character[0].getRectangle().getY() == character[1].getRectangle().getY() &&
                character[0].getRectangle().getX() == character[2].getRectangle().getX() &&
                character[0].getRectangle().getY() == character[2].getRectangle().getY()) {

            character[1].getRectangle().setX(character[0].getRectangle().getX() - 30);
            character[2].getRectangle().setX(character[0].getRectangle().getX() - 30);
        }


        if (!position) {
            character[0].getRectangle().setX(0);
            character[0].getRectangle().setY(0);
            character[1].getRectangle().setX(character[0].getRectangle().getX() - 30);
            character[1].getRectangle().setY(0);
            character[2].getRectangle().setX(character[0].getRectangle().getX() - 30);
            character[2].getRectangle().setY(0);

            position = true;

        }

        for (GameObject object1 : ((Platform3) level3).getGameObjects()) {
            batch.draw(object1.getTexture(), object1.getRectangle().x, object1.getRectangle().y);

            //check if player landed (floor, or platform)
            if (character[0].getRectangle().overlaps(object1.getRectangle()) &&
                    character[1].getRectangle().overlaps(object1.getRectangle()) &&
                    character[2].getRectangle().overlaps(object1.getRectangle())) {
                if (object1 instanceof ExitPoint) {

                    System.out.println("End");
                }
                character[0].getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
                character[0].setFalling(false);
                character[1].getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
                character[1].setFalling(false);
                character[2].getRectangle().y = object1.getRectangle().y + object1.getRectangle().height;
                character[2].setFalling(false);

            }

        }

        batch.draw(character[0].getTexture(), character[0].getPosX(), character[0].getPosY());
        batch.draw(character[1].getTexture(), character[1].getPosX(), character[1].getPosY());
        batch.draw(character[2].getTexture(), character[2].getPosX(), character[2].getPosY());

        if (character[0].isJumping() && character[1].isJumping() && character[2].isJumping()) {
            if ((TimeUtils.nanoTime() - character[0].getLastJumpTime() < 250000000) &&
                    (TimeUtils.nanoTime() - character[1].getLastJumpTime() < 250000000) &&
                    (TimeUtils.nanoTime() - character[2].getLastJumpTime() < 250000000)) {

                character[0].setPosY((int) (character[0].getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
                character[1].setPosY((int) (character[1].getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
                character[2].setPosY((int) (character[2].getPosY() + (Configurations.PLAYER_JUMP * Gdx.graphics.getDeltaTime())));
            }

            if ((TimeUtils.nanoTime() - character[0].getLastJumpTime() > 300000000) &&
                    (TimeUtils.nanoTime() - character[1].getLastJumpTime() > 300000000) &&
                    (TimeUtils.nanoTime() - character[2].getLastJumpTime() > 300000000)) {

                character[0].stopJump();
                character[1].stopJump();
                character[2].stopJump();

            }
        } else {

            character[0].setPosY((int) (character[0].getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));
            character[1].setPosY((int) (character[1].getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));
            character[2].setPosY((int) (character[2].getPosY() - (Configurations.PLAYER_FALL * Gdx.graphics.getDeltaTime())));

        }

        character[0].move();
        character[1].move();
        character[2].move();


        //if player is not jumping, player is allowed to jump
        if (!character[0].isFalling() && !character[1].isFalling() && !character[2].isFalling()) {
            character[0].jump();
            character[1].jump();
            character[2].jump();
        }

    }
}
