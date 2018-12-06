package org.academiadecodigo.hashtronauts.levels;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.battle.BattleController;
import org.academiadecodigo.hashtronauts.battle.PlayerAction;
import org.academiadecodigo.hashtronauts.characters.enemies.Enemy;
import org.academiadecodigo.hashtronauts.characters.player.BattlePlayer;

//View
public class BattleLevel {
    SpriteBatch batch;
    BitmapFont font;
    //Models
    private Enemy enemyModel;
    private BattlePlayer playerModel;

    //Visual objects for battle information
    //positions
    private Rectangle player;
    private Rectangle enemy;
    //Health indicators
    private String playerHp;
    private String enemyHp;
    //user inputs
    private PlayerAction[] playerActions;

    //Controller for battle logic
    private BattleController controller;

    public BattleLevel(BattlePlayer player, Enemy enemyModel, SpriteBatch batch){
        playerModel = player;
        this.enemyModel = enemyModel;
        this.batch = batch;

        init();
    }

    public void init(){
        font = new BitmapFont();
        player = new Rectangle();
        enemy = new Rectangle();

        //Define player and enemyModel position in battle
        player.setPosition(100, 250); //placeholder values
        enemy.setPosition(700, 250);

        //Define health values in text
        playerHp = "Player HP: " + playerModel.getHealth();
        enemyHp = "Enemy HP: " + enemyModel.getHealth();

        //Create a controller
        controller = new BattleController(this);

        //Create player's input options
        playerActions = new PlayerAction[6];
        playerActions[0] = PlayerAction.ATTACK;
        playerActions[1] = PlayerAction.DEFEND;
        playerActions[2] = PlayerAction.YOUR_SKILL;
        playerActions[3] = PlayerAction.BRIAN_SKILL;
        playerActions[4] = PlayerAction.JOHN_SKILL;
        playerActions[4] = PlayerAction.ROGER_SKILL;

        //Start battle
        controller.battleStart();
    }

    public void showPlayerActions(){
        batch.begin();
        for(PlayerAction action : playerActions){
            font.draw( batch, action.getMessage(), action.getX(), action.getY() );
        }
        batch.end();
    }

    public void hidePlayerActions(){
        for(PlayerAction action : playerActions){
            //TODO: find a way to hide text when it's not player's turn
        }
    }

    public void draw(){
        batch.begin();

        font.draw(batch, playerHp, 500, 700);
        font.draw(batch, enemyHp, 600, 700);



        batch.end();

    }


    public Enemy getEnemyModel() {
        return enemyModel;
    }

    public BattlePlayer getPlayerModel() {
        return playerModel;
    }

    public void dispose(){
        batch.begin();
        for(PlayerAction action : playerActions){
            batch.dispose();
        }
    }
}
