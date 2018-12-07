package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import org.academiadecodigo.hashtronauts.battle.BattleController;
import org.academiadecodigo.hashtronauts.battle.PlayerAction;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;
import org.academiadecodigo.hashtronauts.levels.gameObjects.ExitPoint;
import org.academiadecodigo.hashtronauts.levels.gameObjects.GameObject;
import org.academiadecodigo.hashtronauts.levels.platformLevels.PlatformLevel;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform1;
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform2;

public class DeltaGame extends Game {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level1;
    private PlatformPlayer player;

    private PlatformLevel level2;
    private boolean finished1 = true;

    private Battle battle;
    private BattleController battleController;
    private BitmapFont font;


    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Configurations.WINDOW_WIDTH, Configurations.WINDOW_HEIGHT);

        level1 = new Platform1();

        ((Platform1) level1).initLevelObjects();
        level1.levelInit();


        player = level1.getPlayer();

        player.setFalling(false);

        level2 = new Platform2();
        ((Platform2) level2).initLevelObjects();
        level2.levelInit();

        battle = new Battle();
        battle.create();
        font = new BitmapFont();

        battleController = new BattleController();
        battleController.create();

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
            if (player.getRectangle().overlaps(object.getRectangle())) {
                if (object instanceof ExitPoint) {

                    finished1 = true;
                }
                player.getRectangle().y = object.getRectangle().y + object.getRectangle().height;
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
        }

    }

    public void renderLevel2() {

        //Render visuals
        for (PlayerAction action : battle.getPlayerActions()) {
            font.draw(batch, action.getMessage(), action.getX(), action.getY());
        }

        batch.draw(battle.getEnemyHp(), 1600, 1000, battle.getEnemyBar(), 40);
        batch.draw(battle.getPlayerHp(), 200, 1000, battle.getPlayerBar(), 40);

        batch.draw(battle.getPlayer(), 250, 475);
        batch.draw(battle.getGuitar(), 130, 775);
        batch.draw(battle.getBass(), 80, 475);
        batch.draw(battle.getDrums(), 125, 175);

        batch.draw(battle.getEnemy(), 1600, 475);


        //Battle logic
        if (battle.isPlayerTurn()) {
            if (battleController.playerTurn()) {
                if (battleController.getAccuracy() > 10) {
                    batch.draw(battle.getEnemyHp(), 1600, 1000, battle.setEnemyBar(battle.getPlayerModel().getAttackPoints()), 40);
                }
                battle.setPlayerTurn(false);

                if (!battle.isPlayerTurn()) {
                    battle.setPlayerTurn(battleController.enemyTurn());

                    if (battleController.getAccuracy() > 10) {
                        batch.draw(battle.getPlayerHp(), 200, 1000, battle.setPlayerBar(battle.getEnemyModel().getAttackPoints()), 40);

                        if (battle.getEnemyBar() <= 0) {
                            battle.setOver(true);
                        }
                    }
                }
            }
        }


        if (battle.isOver()) {
            font.draw(batch, "Friends will be Friends", 960, 540);
        }
    }
}
