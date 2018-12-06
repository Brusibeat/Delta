package org.academiadecodigo.hashtronauts.characters.player;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public class BattlePlayer extends Player implements BattlingCharacters {

    private int health;
    private int skillCooldown;
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
