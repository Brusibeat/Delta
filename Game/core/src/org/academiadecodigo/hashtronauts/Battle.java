package org.academiadecodigo.hashtronauts;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import org.academiadecodigo.hashtronauts.battle.BattleController;
import org.academiadecodigo.hashtronauts.battle.PlayerAction;
import org.academiadecodigo.hashtronauts.characters.enemies.Enemy;
import org.academiadecodigo.hashtronauts.characters.enemies.EnemyA;
import org.academiadecodigo.hashtronauts.characters.player.BattlePlayer;
import org.academiadecodigo.hashtronauts.characters.player.PlatformPlayer;

public class Battle {

    //Models
    private Enemy enemyModel;
    private BattlePlayer playerModel;

    //Visual objects for battle information
    //positions
    private Texture player;
    private Texture guitar;
    private Texture bass;
    private Texture drums;
    private Texture enemy;
    //Health indicators
    private Texture playerHp;
    private Texture enemyHp;

    private Texture bg;

    private int playerBar = 200;
    private int enemyBar = 200;
    //user inputs
    private PlayerAction[] playerActions;

    //Controller for battle logic
    private BattleController controller;

    private boolean isOver;
    private boolean isPlayerTurn = true;

    public void setPlayerBar(int playerBar) {
        this.playerBar = playerBar;
    }

    public void setEnemyBar(int enemyBar) {
        this.enemyBar = enemyBar;
    }

    public Texture getBg() {
        return bg;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public int getPlayerBar() {
        return playerBar;
    }

    public int setPlayerDmg(int dmg) {
        return this.playerBar -= dmg;
    }

    public int getEnemyBar() {
        return enemyBar;
    }

    public int setEnemyDmg(int dmg) {
        return this.enemyBar -= dmg;
    }

    public void create() {

        enemyModel = new EnemyA(200);
        playerModel = new BattlePlayer(200);

        player = new Texture("1.png");
        guitar = new Texture("2.png");
        bass = new Texture("4.png");
        drums = new Texture("3.png");
        enemy = new Texture("enemy.png");
        bg = new Texture("bg_boss.jpg");

        //Define health values in text
        playerHp = createTexture(200, 40, Color.BLUE);
        enemyHp = createTexture(200, 40, Color.RED);

        //Create a controller
        controller = new BattleController();

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

    private Texture createTexture( int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor( color );
        pixmap.fill();
        return new Texture(pixmap);
    }

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public PlayerAction[] getPlayerActions() {
        return playerActions;
    }

    public Enemy getEnemyModel() {
        return enemyModel;
    }

    public BattlePlayer getPlayerModel() {
        return playerModel;
    }

    public Texture getGuitar() {
        return guitar;
    }

    public Texture getBass() {
        return bass;
    }

    public Texture getDrums() {
        return drums;
    }

    public Texture getPlayer() {
        return player;
    }

    public Texture getEnemy() {
        return enemy;
    }

    public Texture getPlayerHp() {
        return playerHp;
    }

    public Texture getEnemyHp() {
        return enemyHp;
    }

    public BattleController getController() {
        return controller;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }
}
