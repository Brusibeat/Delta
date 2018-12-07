package org.academiadecodigo.hashtronauts.characters.enemies;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public abstract class Enemy implements BattlingCharacters {

    private int health;
    private boolean defending = false;
    private boolean dead = false;
    private boolean isHit = false;
    private int attackPoints = 3;

    public int getAttackPoints() {
        return attackPoints;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void getHit(int dmg) {
        health -= dmg;
        isHit = true;

    }

    public boolean isDefending() {
        return defending;
    }

    public void setDefending() {
        this.defending = false;
    }

    @Override
    public int attack() {
        return 2;
    }

    @Override
    public boolean defend() {
        return true;
    }

    @Override
    public int useSkill() {
        return 0;
    }

    @Override
    public boolean isDead() {
        return dead;
    }
}
