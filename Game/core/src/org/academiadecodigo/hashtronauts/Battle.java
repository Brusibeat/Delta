package org.academiadecodigo.hashtronauts;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.hashtronauts.battle.BattleController;
import org.academiadecodigo.hashtronauts.battle.PlayerAction;
import org.academiadecodigo.hashtronauts.characters.enemies.Enemy;
import org.academiadecodigo.hashtronauts.characters.player.BattlePlayer;
import org.academiadecodigo.hashtronauts.levels.BattleScreen;

public class Battle extends DeltaGame{
    //Screen
    Screen battleScreen;

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

    private boolean isOver;
    private boolean isPlayerTurn;

    @Override
    public void create() {
        battleScreen = new BattleScreen();

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
        controller = new BattleController(battleScreen);

        //Create player's input options
        playerActions = new PlayerAction[6];
        playerActions[0] = PlayerAction.ATTACK;
        playerActions[1] = PlayerAction.DEFEND;
        playerActions[2] = PlayerAction.YOUR_SKILL;
        playerActions[3] = PlayerAction.BRIAN_SKILL;
        playerActions[4] = PlayerAction.JOHN_SKILL;
        playerActions[5] = PlayerAction.ROGER_SKILL;

        isOver = false;
        isPlayerTurn = true;
    }

    public void dispose(){
        batch.begin();
        for(PlayerAction action : playerActions){
            batch.dispose();
        }
        batch.end();
    }

    @Override
    public void render(){
        draw();

        if(isPlayerTurn){
            showPlayerActions();
            controller.playerTurn();

        }else{
            hidePlayerActions();
            controller.enemyTurn();
        }


        if(enemyModel.getHealth() <= 0){
            isOver = true;
        }

        if(isOver){
            dispose();
        }

    }

    public void draw(){
        batch.begin();

        font.draw(batch, playerHp, 500, 700);
        font.draw(batch, enemyHp, 600, 700);

        batch.draw(player);

        batch.end();

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


}
