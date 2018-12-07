package org.academiadecodigo.hashtronauts;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import org.academiadecodigo.hashtronauts.levels.platformLevels.levels.Platform3;

public class DeltaGame extends Game {
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private PlatformLevel level1;
    private PlatformLevel level2;

    private Battle battle;
    private BattleController battleController;
    private BitmapFont font;

    private PlatformLevel level3;

    private PlatformPlayer[] character;

    private boolean position = false;
    private boolean finished1 = false;
    private boolean finished2 = false;
    private boolean finished3 = false;

    private int currentLevel;

    private Music bg_music;
    private Music enemy_music;
    private Sound jump;

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

        battle = new Battle();
        battle.create();
        font = new BitmapFont();

        battleController = new BattleController();
        battleController.create();

        level3 = new Platform3();
        ((Platform3) level3).initLevelObjects();
        level3.levelInit();

        currentLevel = 1;

        jump = Gdx.audio.newSound(Gdx.files.internal("jump.mp3"));

        bg_music = Gdx.audio.newMusic(Gdx.files.internal("bg_music.mp3"));
        bg_music.setLooping(true);
        bg_music.play();

        enemy_music = Gdx.audio.newMusic(Gdx.files.internal("enemy_music.mp3"));
        enemy_music.setLooping(true);

        character[3].setJump(jump);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        if (finished3) {
            renderBattleLevel();
        } else if (finished2) {
            renderLevel3();
        } else if (finished1) {
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
        batch.draw(((Platform1) level1).getBg(), 0, 0);
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
        batch.draw(((Platform2) level2).getBg(), 0, 0);
        for (PlatformPlayer character : character) {
            if (!position) {
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
        batch.draw(((Platform3) level3).getBg(), 0, 0);
        for (PlatformPlayer character : character) {
            if (!position) {
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

    public void renderBattleLevel() {
        bg_music.stop();
        enemy_music.play();
        batch.draw(((Battle) battle).getBg(), 0, 0);
        //Render visuals
        for (PlayerAction action : battle.getPlayerActions()) {
            font.draw(batch, action.getMessage(), action.getX(), action.getY());
        }

        batch.draw(battle.getEnemyHp(), 1600, 1000, battle.getEnemyBar(), 40);
        batch.draw(battle.getPlayerHp(), 200, 1000, battle.getPlayerBar(), 40);

        batch.draw(battle.getPlayer(), 400, 500);
        batch.draw(battle.getGuitar(), 130, 675);
        batch.draw(battle.getBass(), 80, 350);
        batch.draw(battle.getDrums(), 125, 175);

        batch.draw(battle.getEnemy(), 1400, 300);


        //Battle logic
        if (battle.isPlayerTurn()) {
            if (battleController.playerTurn()) {
                if (battleController.getAccuracy() > 10) {
                    if (battle.getEnemyBar() > 0) {
                        batch.draw(battle.getEnemyHp(), 1600, 1000, battle.setEnemyDmg(battle.getPlayerModel().getAttackPoints()), 40);
                    }
                    if (battle.getEnemyBar() <= 0) {
                        battle.setEnemyBar(0);
                    }
                }
                battle.setPlayerTurn(false);

                if (!battle.isPlayerTurn()) {
                    battle.setPlayerTurn(battleController.enemyTurn());

                    if (battleController.getAccuracy() > 10) {
                        batch.draw(battle.getPlayerHp(), 200, 1000, battle.setPlayerDmg(battle.getEnemyModel().getAttackPoints()), 40);

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
