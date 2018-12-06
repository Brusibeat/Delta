package org.academiadecodigo.hashtronauts.characters.enemies;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public abstract class Enemy implements BattlingCharacters {

    private int health;
    private boolean dead = false;

    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }

    @Override
    public void useSkill() {

    }

    @Override
    public boolean isDead() {
        return dead;
    }
}
