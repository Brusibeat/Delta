package org.academiadecodigo.hashtronauts.characters.player;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public class BattlePlayer extends Player implements BattlingCharacters {

    private int health;
    private int skillCooldown = 3;
    private boolean dead;
    private boolean defend;
    private int skillAttack;
    private int attackPoints;




    @Override
    public int attack() {
        setAttackPoints(10);

        if(skillCooldown < 3){
            skillCooldown ++;
        }
        return attackPoints;
    }

    @Override
    public boolean defend() {
        if(skillCooldown < 3){
            skillCooldown ++;
        }
        return defend = true;
    }

    @Override
    public void useSkill() {
        if(skillCooldown != 3){
            setSkillAttack(0);
            skillCooldown++;
        }
        setSkillAttack(15);
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


