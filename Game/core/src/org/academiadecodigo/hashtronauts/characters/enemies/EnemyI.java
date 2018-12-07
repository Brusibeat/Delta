package org.academiadecodigo.hashtronauts.characters.enemies;

public class EnemyI extends Enemy {

    public EnemyI (int health) {
        health = health;
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public void getHit(int dmg) {
        super.getHit(dmg);
    }

    @Override
    public boolean isDefending() {
        return super.isDefending();
    }

    @Override
    public void setDefending() {
        super.setDefending();
    }

    @Override
    public boolean defend() {
        return super.defend();
    }

    @Override
    public int attack() {
        return 4;
    }

    @Override
    public void useSkill() {
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }
}
