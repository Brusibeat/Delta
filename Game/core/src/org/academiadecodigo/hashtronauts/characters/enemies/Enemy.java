package org.academiadecodigo.hashtronauts.characters.enemies;

import org.academiadecodigo.hashtronauts.characters.BattlingCharacters;

public abstract class Enemy implements BattlingCharacters {

    private boolean defending = false;
    private boolean dead = false;
    private int damageDealt;

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public void enemyAction() {}

    public boolean isDefending() {
        return defending;
    }

    public void setDefending() {
        this.defending = false;
    }

    @Override
    public void attack() {}

    @Override
    public void defend() {
        defending = true;
    }

    @Override
    public void useSkill() {}

    @Override
    public boolean isDead() {
        return dead;
    }
}
