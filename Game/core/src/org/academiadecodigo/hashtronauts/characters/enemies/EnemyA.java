package org.academiadecodigo.hashtronauts.characters.enemies;

public class EnemyA extends Enemy {

    private int health = 10;


    public int getHealth() {
        return health;
    }

    @Override
    public void enemyAction() {
        double action = Math.random();

        if (action <= 0.95) {
            attack();
            return;
        }

        defend();
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
    public void defend() {
        super.defend();
    }

    @Override
    public void attack() {
        setDamageDealt(2);
    }

    @Override
    public void useSkill() {
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    public void receiveDamage(int dmg) {
        this.health -= dmg;
    }
}
