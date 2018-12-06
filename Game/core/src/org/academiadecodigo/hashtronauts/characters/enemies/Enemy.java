package org.academiadecodigo.hashtronauts.characters.enemies;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public abstract class Enemy implements BattlingCharacters {

    private int health;
    private boolean dead = false;
    private boolean defend;
    private int attackPoints;

    @Override
    public int attack() {
        return attackPoints;
    }

    @Override
    public boolean defend() {
        return defend = true;
    }

    @Override
    public int useSkill() {

    }

    @Override
    public boolean isDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
