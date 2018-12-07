package org.academiadecodigo.hashtronauts.characters.enemies;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public abstract class Enemy implements BattlingCharacters {

    private int health;
    private boolean defending = false;
    private boolean dead = false;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void getHit(int dmg) {
        health -= dmg;
    }

    public boolean isDefending() {
        return defending;
    }

    public void setDefending() {
        this.defending = false;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public boolean defend() {
        return true;
    }

    @Override
    public void useSkill() {}

    @Override
    public boolean isDead() {
        return dead;
    }
}
