package org.academiadecodigo.hashtronauts.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import org.academiadecodigo.hashtronauts.Battle;
import org.academiadecodigo.hashtronauts.characters.enemies.Enemy;
import org.academiadecodigo.hashtronauts.characters.enemies.EnemyA;
import org.academiadecodigo.hashtronauts.characters.player.BattlePlayer;

public class BattleController {

    //Validation for battle over
    private boolean isOver;
    private Enemy enemy;
    private BattlePlayer player;
    private Battle battle;
    private double accuracy;

    private Sound attack;
    private Sound enemyAttack;

    public void create() {
        attack = Gdx.audio.newSound(Gdx.files.internal("attack.wav"));
        enemyAttack = Gdx.audio.newSound(Gdx.files.internal("enemy.mp3"));

        enemy = new EnemyA(10);
        player = new BattlePlayer(50);
    }

    public boolean playerTurn() {
        //Attack option
        switch (getPlayerInput()) {
            case 'A':
                attack.play();
                enemy.getHit(player.attack());
                System.out.println("Player Attack");
                return true;
            case 'D':
                player.defend();
                System.out.println("Player Defense");
                return true;
            case 'Q':
                if (player.getSkillCooldown() == 0) {
                    attack.play();
                    enemy.getHit(player.useSkill());
                    System.out.println("Player Skill");
                    return true;
                }
            case 'W':
                if (player.getSkillCooldown() == 0) {
                    attack.play();
                    enemy.getHit(player.useBassSkill());
                    System.out.println("Player Skill");
                    return true;

                }
            case 'E':
                if (player.getSkillCooldown() == 0) {
                    attack.play();
                    enemy.getHit(player.useDrumSkill());
                    System.out.println("Player Skill");
                    return true;

                }
            case 'R':
                if (player.getSkillCooldown() == 0) {
                    attack.play();
                    enemy.getHit(player.useGuitarSkill());
                    System.out.println("Player Skill");
                    return true;

                }
        }

        return false;
    }

    public boolean enemyTurn() {
        double random = Math.random();

        if (random < 0.5) {
            if (isSuccessful()) {
                enemyAttack.play();
                player.getHit(enemy.attack());
                System.out.println("Enemy Attack");
                return true;
            }
        }

        if (random < 0.7) {
            System.out.println("Enemy Defense");
            enemy.defend();
            return true;
        }

        if (random < 1) {
            if (isSuccessful()) {
                enemyAttack.play();
                player.getHit(enemy.useSkill());
                System.out.println("Enemy Skill");
                return true;
            }
        }

        return true;
    }


    public char getPlayerInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            if (isSuccessful()) {
                System.out.println("A pressed");
                return 'A';
            }
        }
        //Defend option
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            System.out.println("D pressed");
            return 'D';
        }

        //Skill options
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            if (isSuccessful()) {
                System.out.println("Q pressed");
                return 'Q';
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            if (isSuccessful()) {
                System.out.println("W pressed");
                return 'W';
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            if (isSuccessful()) {
                System.out.println("E pressed");
                return 'E';
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            if (isSuccessful()) {
                System.out.println("R pressed");
                return 'R';
            }
        }

        return 'n';
    }

    public double getAccuracy() {
        return accuracy;
    }

    public boolean isSuccessful() {
        accuracy = Math.random() * 100;
        if (accuracy >= 10) {
            return true;
        }
        return false;
    }

}
