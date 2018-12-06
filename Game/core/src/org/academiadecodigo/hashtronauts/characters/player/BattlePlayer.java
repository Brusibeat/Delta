package org.academiadecodigo.hashtronauts.characters.player;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

import java.util.Random;

public class BattlePlayer extends Player implements BattlingCharacters {

    private int health;
    private int skillCooldown;
    private boolean dead;
    private boolean defend;



    @Override
    public int attack() {

        int attackPoints = 10;
        Random result = new Random();

        int attackSuccess = result.nextInt(100-0) + 0;
        System.out.println(attackSuccess);

        if(attackSuccess >= 10){
           return attackPoints;
        }
        return 0;
    }

    @Override
    public boolean defend() {
        return defend = true;
    }

    @Override
    public void useSkill() {

    }

    @Override
    public boolean isDead() {
        if(health <= 0){
            return dead = true;
        }
        return dead;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSkillCooldown() {
        return skillCooldown;
    }

    public void setSkillCooldown(int skillCooldown) {
        this.skillCooldown = skillCooldown;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDefend() {
        return defend;
    }

    public void setDefend(boolean defend) {
        this.defend = defend;
    }
}


