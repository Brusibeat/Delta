package org.academiadecodigo.hashtronauts.characters.player;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public class BattlePlayer extends Player implements BattlingCharacters {

    private int health;
    private int skillCooldown;
    private boolean dead;
    private boolean defend;
    private int skillAttack;
    private int attackPoints;

    public BattlePlayer(int health){
        this.health = health;
        this.skillCooldown = 3;

        this.dead = false;
        this.defend = false;
        this.skillAttack = 15;
        this.attackPoints = 10;

    }

    @Override
    public int attack() {

        if(skillCooldown < 3){
            skillCooldown --;
        }
        if(skillCooldown <= 0){
            skillCooldown = 0;
        }
        return attackPoints;
    }

    @Override
    public boolean defend() {
        if(skillCooldown < 3){
            skillCooldown ++;
        }
        if(skillCooldown >= 3){
            skillCooldown = 3;
        }
        return defend = true;
    }

    @Override
    public int useSkill() {
        skillCooldown = 3;
        return skillAttack;
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

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDefend() {
        return defend;
    }

    public void setDefend(boolean defend) {
        this.defend = defend;
    }

    public int getSkillAttack() {
        return skillAttack;
    }

    public void setSkillAttack(int skillAttack) {
        this.skillAttack = skillAttack;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}


