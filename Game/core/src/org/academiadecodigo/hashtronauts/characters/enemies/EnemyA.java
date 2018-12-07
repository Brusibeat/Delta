package org.academiadecodigo.hashtronauts.characters.enemies;

public class EnemyA extends Enemy {

    public EnemyA (int health) {
        health = health;
    }

    @Override
    public int getAttackPoints() {
        return super.getAttackPoints();
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
        return 2;
    }

    @Override
    public int useSkill() {
        return 5;
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

}
